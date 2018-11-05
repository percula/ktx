package com.perculacreative.ktx

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

fun <X, Y> LiveData<X>.map(mapFunction: (value: X?) -> Y): LiveData<Y> {
    return Transformations.map(this, mapFunction)
}

fun <X, Y> LiveData<X>.switchMap(mapFunction: (value: X?) -> LiveData<Y>): LiveData<Y> {
    return Transformations.switchMap(this, mapFunction)
}