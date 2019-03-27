package com.percula.ktx.listlivedata

import androidx.databinding.ObservableList
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.percula.ktx.toObservableList

/**
 * A [LiveData] that notifies observers each time it's list is updated
 *
 * @param initialValue Value to initialize [ListLiveData] with
 */
open class ListLiveData<T>(val initialValue: List<T>? = null): LiveData<ObservableList<T>?>(), ListableLiveData<T> {

    private val callback: ObservableList.OnListChangedCallback<ObservableList<T>> = object: ObservableList.OnListChangedCallback<ObservableList<T>>() {
        override fun onChanged(sender: ObservableList<T>?) = onListChanged()

        override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) =
                onListChanged()

        override fun onItemRangeMoved(sender: ObservableList<T>?, fromPosition: Int, toPosition: Int, itemCount: Int) =
                onListChanged()

        override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) =
                onListChanged()

        override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) =
                onListChanged()
    }

    init {
        initialValue?.let {
            super.setValue(it.toObservableList().apply { this.addOnListChangedCallback(callback) })
        } ?: super.setValue(MyObservableArrayList<T>().apply { this.addOnListChangedCallback(callback) })
    }

    open fun onListChanged() {
        notifyObservers()
    }

    /**
     * Manually notifies observers that this value has changed
     */
    private fun notifyObservers() {
        super.setValue(value)
    }

    override fun getValue(): ObservableList<T> {
        return super.getValue() ?: kotlin.run {
            val list = MyObservableArrayList<T>()
            postValue(list)
            list.addOnListChangedCallback(callback)
            return@run list
        }
    }
}

interface ListableLiveData<T> {
    fun getValue(): ObservableList<T>?
    fun observe(owner: LifecycleOwner, observer: Observer<in ObservableList<T>?>)
}

interface MutableListableLiveData<T> : ListableLiveData<T> {
    fun setValue(value: ObservableList<T>?)
}

fun <T> listLiveDataOf(vararg items: T): ListLiveData<T> {
    return ListLiveData(initialValue = items.toList())
}

fun <T> listLiveDataOf(list: Collection<T>): ListLiveData<T> {
    return ListLiveData(initialValue = list.toList())
}