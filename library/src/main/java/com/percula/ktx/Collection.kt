package com.percula.ktx

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.percula.ktx.listlivedata.MyObservableArrayList

/**
 * Adds the item if it is not in the collection or removes it if it is.
 * @return Whether this collection contains the item, AFTER this operation
 */
fun <T> MutableCollection<T>.addOrRemove(item: T): Boolean {
    return if (contains(item)) {
        remove(item)
        false
    } else {
        add(item)
        true
    }
}

/**
 * Returns true if an element matching the given [predicate] was found.
 */
inline fun <T> Iterable<T>.contains(predicate: (T) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

fun <T> MutableCollection<T>.replaceWith(collection: Collection<T>) {
    if (collection === this) return
    clear()
    addAll(collection)
}

/**
 * Replaces the first item within the list that matches the given predicate or adds the item to
 * the list if none match.
 */
fun <T> MutableList<T>.addOrReplace(item: T, predicate: (T) -> Boolean): Boolean {
    return this.indexOfFirst { predicate.invoke(it) }
            .takeIf { it >= 0 }
            ?.let { this[it] = item }
            ?.let { true }
    ?: this.add(item)
            .let { false }
}

fun <S: MutableList<T>, T> S.addAnd(index: Int, item: T): S {
    add(index, item)
    return this
}

fun <S: MutableCollection<T>, T> S.addAnd(item: T): S{
    add(item)
    return this
}

fun <T> MutableCollection<T>.addAll(vararg items: T) {
    addAll(items)
}

fun <T> Collection<T>?.isNullOrEmpty(): Boolean {
    return (this == null || this.isEmpty())
}

fun <T> Collection<T>.toObservableArrayList(): ObservableArrayList<T> =
        MyObservableArrayList<T>().apply { replaceWith(this@toObservableArrayList) }

fun <T> Collection<T>.toObservableList(): ObservableList<T> =
        MyObservableArrayList<T>().apply { replaceWith(this@toObservableList) }