package com.example.zaq.kotlinframe.weight

import android.content.Context
import android.support.v7.widget.AppCompatSeekBar
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * 禁止拖动
 * Created by zaq on 2017/7/31.
 */

class FSeekBar : AppCompatSeekBar {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return false
    }
}
