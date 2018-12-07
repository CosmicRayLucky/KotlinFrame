package com.example.zaq.kotlinframe.core

import io.reactivex.observers.DisposableObserver

/**
 * Created by Zhang Aqi on 2018/7/23. 15:35
 * mail:1095187377@qq.com
 */
abstract class CommonDisposableObserver<T> : DisposableObserver<T>() {

    override fun onComplete() {
    }

}