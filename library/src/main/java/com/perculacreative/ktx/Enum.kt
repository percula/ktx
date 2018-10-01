package com.perculacreative.ktx

inline fun <reified T : Enum<T>> Enum<T>.safeValueOf(name: String): T? {
    return try {
        enumValueOf<T>(name)
    } catch (e: IllegalArgumentException) {
        null
    }
}
