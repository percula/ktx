package dev.percula.ktx

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

public suspend inline fun <T, R> T.onMain(crossinline block: (T) -> R): R {
    return withContext(Dispatchers.Main) { this@onMain.let(block) }
}

public suspend inline fun <T, R> T.onDefault(crossinline block: (T) -> R): R {
    return withContext(Dispatchers.Default) { this@onDefault.let(block) }
}

public suspend inline fun <T, R> T.onIO(crossinline block: (T) -> R): R {
    return withContext(Dispatchers.IO) { this@onIO.let(block) }
}