package dev.percula.ktx.listlivedata

import androidx.databinding.ObservableArrayList

// TODO: Remove once https://issuetracker.google.com/issues/113075721 is fixed
class MyObservableArrayList<T>: ObservableArrayList<T>() {

    override fun removeAll(elements: Collection<T>): Boolean {
        var success = false
        elements.forEach { if (super.remove(it)) success = true }
        return success
    }

    fun removeAllDoNotNotify(elements: Collection<T>): Boolean {
        return super.removeAll(elements)
    }

}