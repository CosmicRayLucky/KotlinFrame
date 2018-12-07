package com.example.zaq.kotlinframe.core

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan

/**
 * Created by zaq on 2018-7-20
 */
object StringUtils {

    /**
     * 首行缩进两格
     *
     * @param s
     * @return
     */
    fun retract(s: String): SpannableStringBuilder {
        val span = SpannableStringBuilder("缩进$s")
        span.setSpan(ForegroundColorSpan(Color.TRANSPARENT), 0, 2,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        return span
    }
}
