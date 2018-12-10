package com.example.zaq.kotlinframe.extension

/**
 * Created by Zhang Aqi on 2018/11/30. 15:24
 * mail:1095187377@qq.com
 */
inline fun <reified T, E> io.reactivex.Observable<T>.bind2Lifecycle(
    lifecycleProvider: com.trello.rxlifecycle2.LifecycleProvider<E>,
    disposableObserver: io.reactivex.observers.DisposableObserver<T>
): io.reactivex.disposables.Disposable =
    this.subscribeOn(io.reactivex.schedulers.Schedulers.io())
        .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribeWith(disposableObserver)