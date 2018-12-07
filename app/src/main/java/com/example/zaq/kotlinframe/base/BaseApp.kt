package com.example.zaq.kotlinframe.base

import android.support.multidex.MultiDexApplication
import com.tencent.bugly.Bugly

/**
 * Application基类
 * Created by Zhang Aqi on 2018/8/27. 10:25
 * mail:1095187377@qq.com
 */
open class BaseApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        // 腾讯Bugly初始化
        Bugly.init(applicationContext, "", true)
    }
}
