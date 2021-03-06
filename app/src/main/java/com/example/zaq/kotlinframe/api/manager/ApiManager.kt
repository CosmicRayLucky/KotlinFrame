package com.example.zaq.kotlinframe.api.manager

import com.example.zaq.kotlinframe.api.HttpPath
import com.example.zaq.kotlinframe.api.service.ApiService
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

/**
 * Created by Zhang Aqi on 2018/12/10. 13:50
 * mail:1095187377@qq.com
 */
class ApiManager {
    private val mApiService = RetrofitManager.builder(HttpPath.BASE_URL).create(ApiService::class.java)

    private object LazySingle {
        val INSTANCE = ApiManager()
    }

    companion object {
        fun builder() = LazySingle.INSTANCE
    }

//    fun <T> postPaperFactor(
//        disposableObserver: DisposableObserver<PostPaperFactorResponse>,
//        PaperID: String,
//        lifecycleProvider: LifecycleProvider<T>
//    ): Disposable =
//        mApiService.postPaperFactor(PaperID = PaperID).bind2Lifecycle(
//            lifecycleProvider,
//            disposableObserver
//        )


}