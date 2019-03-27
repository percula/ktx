package com.percula.ktx

fun <K, V> Map<K, V?>.filterNotNullValues(): Map<K, V> {
    return mapNotNull { (key, nullableValue) ->
        nullableValue?.let { key to it }
    }.toMap()
}

fun <T, S> MutableMap<T, S>.replaceWith(map: Map<T, S>) {
    if (map === this) return
    clear()
    putAll(map)
}