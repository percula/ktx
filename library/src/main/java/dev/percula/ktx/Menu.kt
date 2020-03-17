package dev.percula.ktx

import android.view.Menu
import android.view.MenuItem
import androidx.core.view.iterator

/** Performs the given action on each item in this menu. */
inline fun Menu.filter(action: (item: MenuItem) -> Boolean): List<MenuItem> {
    val filteredItems = mutableListOf<MenuItem>()
    this.iterator().forEach {
        if (action.invoke(it)) filteredItems.add(it)
    }
    return filteredItems
}