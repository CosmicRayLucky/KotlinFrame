package com.example.zaq.kotlinframe.core

import com.example.zaq.kotlinframe.App

/**
 * Created by Zhang Aqi on 2019/2/15. 09:44
 * mail:1095187377@qq.com
 */
class DimenUtil {
    /** sp转换成px  */
    fun sp2px(spValue: Float): Int {
        val fontScale = App.sAppContext.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    /** px转换成sp  */
    fun px2sp(pxValue: Float): Int {
        val fontScale = App.sAppContext.resources.displayMetrics.density
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /** dip转换成px  */
    fun dip2px(dipValue: Float): Int {
        val scale = App.sAppContext.resources.displayMetrics.scaledDensity
        return (dipValue * scale + 0.5f).toInt()
    }

    /** px转换成dip  */
    fun px2dip(pxValue: Float): Int {
        val scale = App.sAppContext.resources.displayMetrics.scaledDensity
        return (pxValue / scale + 0.5f).toInt()
    }
}