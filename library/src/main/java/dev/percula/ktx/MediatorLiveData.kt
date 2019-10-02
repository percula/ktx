package dev.percula.ktx

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

fun <A, B, T> mediatorLiveDataOf(
        liveDataA: LiveData<A>,
        liveDataB: LiveData<B>,
        action: ((A?, B?) -> T)) = object : MediatorLiveData<T>() {

    init {
        addSource(liveDataA) { value = action.invoke(it, liveDataB.value) }
        addSource(liveDataB) { value = action.invoke(liveDataA.value, it) }
    }

}

fun <A, B, C, T> mediatorLiveDataOf(
        liveDataA: LiveData<A>,
        liveDataB: LiveData<B>,
        liveDataC: LiveData<C>,
        action: ((A?, B?, C?) -> T)) = object : MediatorLiveData<T>() {

    init {
        addSource(liveDataA) { value = action.invoke(it, liveDataB.value, liveDataC.value) }
        addSource(liveDataB) { value = action.invoke(liveDataA.value, it, liveDataC.value) }
        addSource(liveDataC) { value = action.invoke(liveDataA.value, liveDataB.value, it) }
    }

}

fun <A, B, C, D, T> mediatorLiveDataOf(
        liveDataA: LiveData<A>,
        liveDataB: LiveData<B>,
        liveDataC: LiveData<C>,
        liveDataD: LiveData<D>,
        action: ((A?, B?, C?, D?) -> T)) = object : MediatorLiveData<T>() {

    init {
        addSource(liveDataA) { value = action.invoke(it, liveDataB.value, liveDataC.value, liveDataD.value) }
        addSource(liveDataB) { value = action.invoke(liveDataA.value, it, liveDataC.value, liveDataD.value) }
        addSource(liveDataC) { value = action.invoke(liveDataA.value, liveDataB.value, it, liveDataD.value) }
        addSource(liveDataD) { value = action.invoke(liveDataA.value, liveDataB.value, liveDataC.value, it) }
    }

}

fun <A, B, C, D, E, T> mediatorLiveDataOf(
        liveDataA: LiveData<A>,
        liveDataB: LiveData<B>,
        liveDataC: LiveData<C>,
        liveDataD: LiveData<D>,
        liveDataE: LiveData<E>,
        action: ((A?, B?, C?, D?, E?) -> T)) = object : MediatorLiveData<T>() {

    init {
        addSource(liveDataA) { value = action.invoke(it, liveDataB.value, liveDataC.value, liveDataD.value, liveDataE.value) }
        addSource(liveDataB) { value = action.invoke(liveDataA.value, it, liveDataC.value, liveDataD.value, liveDataE.value) }
        addSource(liveDataC) { value = action.invoke(liveDataA.value, liveDataB.value, it, liveDataD.value, liveDataE.value) }
        addSource(liveDataD) { value = action.invoke(liveDataA.value, liveDataB.value, liveDataC.value, it, liveDataE.value) }
        addSource(liveDataE) { value = action.invoke(liveDataA.value, liveDataB.value, liveDataC.value, liveDataD.value, it) }
    }

}

fun <A, B, C, D, E, F, T> mediatorLiveDataOf(
        liveDataA: LiveData<A>,
        liveDataB: LiveData<B>,
        liveDataC: LiveData<C>,
        liveDataD: LiveData<D>,
        liveDataE: LiveData<E>,
        liveDataF: LiveData<F>,
        action: ((A?, B?, C?, D?, E?, F?) -> T)) = object : MediatorLiveData<T>() {

    init {
        addSource(liveDataA) { value = action.invoke(it, liveDataB.value, liveDataC.value, liveDataD.value, liveDataE.value, liveDataF.value) }
        addSource(liveDataB) { value = action.invoke(liveDataA.value, it, liveDataC.value, liveDataD.value, liveDataE.value, liveDataF.value) }
        addSource(liveDataC) { value = action.invoke(liveDataA.value, liveDataB.value, it, liveDataD.value, liveDataE.value, liveDataF.value) }
        addSource(liveDataD) { value = action.invoke(liveDataA.value, liveDataB.value, liveDataC.value, it, liveDataE.value, liveDataF.value) }
        addSource(liveDataE) { value = action.invoke(liveDataA.value, liveDataB.value, liveDataC.value, liveDataD.value, it, liveDataF.value) }
        addSource(liveDataF) { value = action.invoke(liveDataA.value, liveDataB.value, liveDataC.value, liveDataD.value, liveDataE.value, it) }
    }

}