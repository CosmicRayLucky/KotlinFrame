package com.example.zaq.kotlinframe.api.interceptor

import com.example.zaq.kotlinframe.App
import com.example.zaq.kotlinframe.api.interceptor.util.PersistentCookieStore
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl


/**
 *
 * Created by Zhang Aqi on 2018/9/18. 10:06
 * mail:1095187377@qq.com
 */
class CookieJarImpl : CookieJar {
    private val cookieStore = PersistentCookieStore(App.sAppContext)
    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        cookieStore[url.host()] = cookies
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        return cookieStore[url.host()] ?: mutableListOf()
    }
}