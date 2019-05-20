package dev.percula.ktx.listlivedata

import androidx.databinding.ObservableList

class MutableListLiveData<T>(initialValue: List<T>? = null) : ListLiveData<T>(initialValue), MutableListableLiveData<T> {

    override fun setValue(value: ObservableList<T>?) {
        super.setValue(value)
    }
}

interface MutableListableLiveData<T> : ListableLiveData<T> {
    fun setValue(value: ObservableList<T>?)
}

fun <T> mutableListLiveDataOf(vararg items: T): MutableListLiveData<T> {
    return MutableListLiveData(initialValue = items.toList())
}

fun <T> mutableListLiveDataOf(list: Collection<T>): MutableListLiveData<T> {
    return MutableListLiveData(initialValue = list.toList())
}