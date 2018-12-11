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
    private var scrollEnable = true

    override fun onTouchEvent(ev: MotionEvent): Boolean = if (scrollEnable) super.onTouchEvent(ev) else false

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean = if (scrollEnable) super.onTouchEvent(ev) else false

    fun setScollEnable(scrollEnable: Boolean) {
        this.scrollEnable = scrollEnable
    }
}
