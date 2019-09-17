package dev.percula.ktx

/**
 * Returns an enum entry with specified name. If the enum has overriden toString(), it will use that
 */
inline fun <reified T : Enum<T>> enumSafeValueOf(name: String): T? {
    return try {
        enumValueOf<T>(name)
    } catch (e: Exception) {
        enumValues<T>().firstOrNull { it.toString() == name }
    }
}