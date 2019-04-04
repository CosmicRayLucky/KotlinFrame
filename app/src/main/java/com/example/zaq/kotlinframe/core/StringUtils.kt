package com.example.zaq.kotlinframe.core

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import java.util.*

/**
 * Created by zaq on 2018-7-20
 */
object StringUtils {

    var serialNo = charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

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

    /**
     * 获取指定位数的序列号
     * 张普
     * 2018-5-31
     * @param size
     * @return
     */
    fun getSerialNo(size: Int): String {
        val random = Random()
        val cs = CharArray(size)
        for (i in cs.indices) {
            cs[i] = serialNo[random.nextInt(serialNo.size)]
        }
        return String(cs)
    }
}
