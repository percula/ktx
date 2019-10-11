package dev.percula.ktx

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

@Deprecated(
        "Use androidx.lifecycle extension function instead",
        ReplaceWith("Transformations.map(this, mapFunction)", "androidx.lifecycle.Transformations")
)
fun <X, Y> LiveData<X>.map(mapFunction: (value: X?) -> Y?) =
        Transformations.map(this, mapFunction)

@Deprecated(
        "Use androidx.lifecycle extension function instead",
        ReplaceWith("Transformations.switchMap(this, mapFunction)", "androidx.lifecycle.Transformations")
        )
fun <X, Y> LiveData<X>.switchMap(mapFunction: (value: X?) -> LiveData<Y>): LiveData<Y> =
        Transformations.switchMap(this, mapFunction)

fun <T> MutableLiveData<T>.notifyObservers(): MutableLiveData<T> {
        value = value
        return this
}