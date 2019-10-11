package dev.percula.ktx

import androidx.lifecycle.LiveData

/**
 * A LiveData that enforces the generic type's nullability
 */
open class NonNullLiveData<T>(private val initialValue: T): LiveData<T>() {

    init {
        value = initialValue
    }

    /**
     * If for some reason the value is null, just return the initial value
     */
    override fun getValue(): T {
        return super.getValue() ?: initialValue
    }

    fun notifyObservers(): NonNullLiveData<T> {
        value = value
        return this
    }

}