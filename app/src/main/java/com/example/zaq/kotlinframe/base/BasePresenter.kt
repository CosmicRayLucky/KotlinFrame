package com.example.zaq.kotlinframe.base

import java.lang.NullPointerException
import java.lang.ref.WeakReference

/**
 * Presenter基类
 * Created by Zhang Aqi on 2018/12/6. 14:03
 * mail:1095187377@qq.com
 */
abstract class BasePresenter<V : IView> : IPresenter<V> {
    private var mView: WeakReference<V>? = null

    fun getView() = mView ?: throw NullPointerException("mView is null !")

    override fun attachView(view: V) {
        mView = WeakReference(view)
    }

    override fun detachView() {
        mView ?: return
        mView?.clear()
        mView = null
    }
}