package dev.percula.ktx

import androidx.lifecycle.MutableLiveData

/**
 * Creates a [MutableLiveData] with the initial value set
 * @param value Initial value to set
 * @return [MutableLiveData] with the initial value set
 */
fun <T> mutableLiveDataOf(value: T?): MutableLiveData<T> {
    val liveData = MutableLiveData<T>()
    liveData.value = value
    return liveData
}

/**
 * Creates a [MutableLiveData] with no initial value
 */
fun <T> mutableLiveDataOf(): MutableLiveData<T> {
    return MutableLiveData()
}