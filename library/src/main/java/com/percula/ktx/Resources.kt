package com.percula.ktx

import android.content.res.Resources
import android.os.Build
import androidx.annotation.ColorRes

fun Resources.getColorCompat(@ColorRes id: Int, theme: Resources.Theme?): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        getColor(id, theme)
    } else {
        getColor(id)
    }
}