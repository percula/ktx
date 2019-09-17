package dev.percula.ktx

import android.view.View
import androidx.annotation.IdRes
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Binds the view lazily with consideration of the activity's lifecycle.
 */
fun <T : View> ComponentActivity.bind(@IdRes idRes: Int): ReadOnlyProperty<ComponentActivity, T?> {
    return LifecycleOwnerBinder(this) {
        it.findViewById<T>(idRes)
    }
}

/**
 * Binds the view lazily with consideration of the fragment's lifecycle.
 */
fun <T : View> Fragment.bind(@IdRes idRes: Int): ReadOnlyProperty<Fragment, T?> {
    return LifecycleOwnerBinder(this) {
        it.view?.findViewById<T>(idRes)
    }
}

/**
 * Binds the view lazily. Note, if the view is destroyed and recreated, this may
 * reference a non-existing view.
 */
fun <T : View> View.bind(@IdRes idRes: Int): Lazy<T?> {
    return unsafeLazy { findViewById<T>(idRes) }
}

private fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

private class LifecycleOwnerBinder<out T : View, S : LifecycleOwner>(
        val lifecycleOwner: S,
        val initializer: (S) -> T?
) : ReadOnlyProperty<S, T?>, LifecycleObserver {
    private object EMPTY
    private var viewValue: Any? = EMPTY

    init {
        if (lifecycleOwner is Fragment) {
            lifecycleOwner.viewLifecycleOwnerLiveData.observe(lifecycleOwner, Observer {
                it.lifecycle.addObserver(this)
            })
        } else {
            lifecycleOwner.lifecycle.addObserver(this)
        }
    }

    override fun getValue(thisRef: S, property: KProperty<*>): T? {
        if (viewValue === EMPTY) {
            viewValue = initializer(lifecycleOwner)
        }
        @Suppress("UNCHECKED_CAST")
        return viewValue as? T
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onViewDestroyed() {
        viewValue = EMPTY
    }
}