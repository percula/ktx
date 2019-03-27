package dev.percula.ktx

/**
 * Returns an enum entry with specified name.
 */
inline fun <reified T : Enum<T>> enumSafeValueOf(name: String): T? {
    return try {
        enumValueOf<T>(name)
    } catch (e: Exception) {
        null
    }
}