package dev.percula.ktx

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

fun <T> MutableLiveData<T>.notifyObservers(): MutableLiveData<T> {
        value = value
        return this
}

/**
 * Similar to LiveData.map {}, but with an initial value for the LiveData.
 */
inline fun <X, Y> LiveData<X>.map(initialValue: Y, crossinline transform: (X) -> Y?): LiveData<Y> {
        val result = MediatorLiveData<Y>()
        result.value = initialValue
        result.addSource(this) { result.value = transform(it) }
        return result
}

/**
 * Maps the value from the source [LiveData] using the [transform] function into a [MutableLiveData].
 * When the value is set (by two-way data binding, for example), [onUpdate] is called.
 *
 * This is particularly useful for two-way Android DataBinding with text fields. When the [EditText]
 * sets the value, after an optional delay of [updateDelayTimeMS], [onUpdate] could update the
 * object on the network. Or the value within the source [LiveData] could be updated.
 */
inline fun <X, Y> LiveData<X>.mapWithUpdateAction(scope: CoroutineScope = GlobalScope,
                                                  updateDelayTimeMS: Long = 0L,
                                                  crossinline transform: (X) -> Y,
                                                  crossinline onUpdate: (X?, Y) -> Unit): MediatorLiveData<Y> {
        return object : MediatorLiveData<Y>() {
                var job: Job? = null

                init {
                        addSource(this@mapWithUpdateAction) { super.setValue(transform(it)) }
                }

                override fun setValue(value: Y) {
                        if (value?.equals(this.value) == true) return
                        super.setValue(value)

                        job?.cancel()
                        job = scope.launch {
                                withContext(Dispatchers.Default) { delay(updateDelayTimeMS) }
                                onUpdate(this@mapWithUpdateAction.value, value)
                        }
                }
        }
}

/**
 * Maps the value from the source [LiveData] using the [transform] function into a [MutableLiveData].
 *
 * This is particularly useful for two-way Android DataBinding with text fields.
 */
inline fun <X, Y> LiveData<X>.mapToMutable(crossinline transform: (X) -> Y) : MediatorLiveData<Y> {
        return object : MediatorLiveData<Y>() {
                init { addSource(this@mapToMutable) { super.setValue(transform(it)) } }
        }
}