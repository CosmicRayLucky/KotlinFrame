package com.example.zaq.kotlinframe.core

import android.content.Context
import android.view.inputmethod.InputMethodManager

import java.lang.reflect.Field

/**
 * 解决InputMethodManager  mLastSrvView内存泄露
 * Created by Zhang Aqi on 2019/3/18. 09:37
 * mail:1095187377@qq.com
 */
object FixMemLeak {
    private var field: Field? = null
    private var hasField = true

    fun fixLeak(context: Context) {
        if (!hasField) {
            return
        }
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return

        val arr = arrayOf("mLastSrvView")
        for (param in arr) {
            try {
                if (null == field) {
                    field = imm.javaClass.getDeclaredField(param)
                }
                if (null == field) {
                    hasField = false
                }
                if (field != null) {
                    field!!.isAccessible = true
                    field!!.set(imm, null)
                }
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}
