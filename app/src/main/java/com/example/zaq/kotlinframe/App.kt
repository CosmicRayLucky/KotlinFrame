package com.example.zaq.kotlinframe

import android.content.Context
import com.example.zaq.kotlinframe.base.BaseApp

/**
 * Created by Zhang Aqi on 2018/12/6. 14:08
 * mail:1095187377@qq.com
 */
class App : BaseApp() {
    companion object {
        lateinit var sAppContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        sAppContext = this
    }
}