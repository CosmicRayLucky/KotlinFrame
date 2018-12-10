package com.example.zaq.kotlinframe.weight

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * 可切换滚动或者不滚动的ViewPager
 * Created by zaq on 2017/8/23
 */

class FreeViewPager(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    private var scollEnable = true

    fun setScollEnable(scollEnable: Boolean) {
        this.scollEnable = scollEnable
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (!scollEnable) {
            false
        } else super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (!scollEnable) {
            false
        } else super.onInterceptTouchEvent(ev)
    }
}
