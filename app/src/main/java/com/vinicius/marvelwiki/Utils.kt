package com.vinicius.marvelwiki

import android.util.DisplayMetrics
import android.view.WindowManager
import kotlin.math.roundToInt

object Utils {
    fun calculateBestSpanCount(windowManager: WindowManager, posterWidth: Int): Int {
        val display = windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)
        val screenWidth = outMetrics.widthPixels.toFloat()
        return (screenWidth / posterWidth).roundToInt()
    }
}