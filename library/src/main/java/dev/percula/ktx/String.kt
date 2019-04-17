package dev.percula.ktx

fun String.removeSymbols(replacement: String = "�"): String {
    return this.replace(Regex("[^\\p{ASCII}‘’]"), replacement)
}

fun String.containsAny(vararg strings: String): Boolean {
    return strings.any { this.contains(it) }
}

fun String.capitalizeWords(): String {
    return this.split(" ").joinToString(" ") { it.capitalize() }
}

fun String.camelCaseWords(): String {
    return this.toLowerCase().capitalizeWords()
}

fun String.trimTo(length: Int): String {
    return if (this.length < length) {
        this
    } else {
        this.substring(0, length - 1).plus("…")
    }
}

fun Collection<String>.containsCaseInsensitive(string: String): Boolean {
    forEach {
        if (it.equals(string, true)) {
            return true
        }
    }
    return false
}

fun Collection<String>.indexCaseInsensitive(string: String): Int {
    forEachIndexed { index, s ->
        if (s.equals(string, true)) {
            return index
        }
    }
    return -1
}