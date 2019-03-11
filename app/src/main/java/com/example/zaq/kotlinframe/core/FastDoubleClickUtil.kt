package com.example.zaq.kotlinframe.core

/**
 * 检测用户快速双击工具类
 * Created by zaq on 16/7/25.
 */
object FastDoubleClickUtil {

    private var lastClickTime: Long = 0

    private val MIN_CLICK_DELAY_TIME = 300

    val isFastDoubleClick: Boolean
        get() {
            val time = System.currentTimeMillis() - lastClickTime
            lastClickTime = System.currentTimeMillis()
            return time in 1..(MIN_CLICK_DELAY_TIME - 1)
        }

}
