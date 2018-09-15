package com.perculacreative.ktx

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

fun <T> MutableCollection<T>.replaceWith(collection: Collection<T>) {
    if (collection === this) return
    clear()
    addAll(collection)
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
