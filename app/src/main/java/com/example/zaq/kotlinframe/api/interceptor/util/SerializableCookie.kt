package com.example.zaq.kotlinframe.api.interceptor.util

import okhttp3.Cookie
import java.io.Serializable

/**
 * 序列化的Cookie对象
 * Created by Zhang Aqi on 2018/9/18. 13:42
 * mail:1095187377@qq.com
 */
class SerializableCookie(cookie: Cookie) : Serializable {
    private val name: String? = cookie.name()
    private val value: String? = cookie.value()
    private val expiresAt: Long?
    private val domain: String?
    private val path: String?
    private val secure: Boolean?
    private val httpOnly: Boolean?
    private val hostOnly: Boolean?

    init {
        expiresAt = cookie.expiresAt()
        domain = cookie.domain()
        path = cookie.path()
        secure = cookie.secure()
        httpOnly = cookie.httpOnly()
        hostOnly = cookie.hostOnly()
    }

    /**
     * 从当前对象中参数生成一个Cookie
     * @author cxm
     */
    fun cookie(): Cookie {
        return Cookie.Builder()
                .name(name)
                .value(value)
                .expiresAt(expiresAt ?: 0L)
                .path(path)
                .let {
                    if (secure == true) it.secure()
                    if (httpOnly == true) it.httpOnly()
                    if (hostOnly == true)
                        it.hostOnlyDomain(domain)
                    else
                        it.domain(domain)
                    it
                }
                .build()
    }
}