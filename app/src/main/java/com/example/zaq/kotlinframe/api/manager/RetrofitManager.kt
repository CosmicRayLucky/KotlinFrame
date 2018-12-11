package com.example.zaq.kotlinframe.api.manager

import android.util.Log
import com.example.zaq.kotlinframe.api.HttpPath
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.example.zaq.kotlinframe.api.interceptor.CookieJarImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager private constructor(baseUrl: String) {
    val retrofit: Retrofit

    init {
        initOkHttpClient()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(mOkHttpClient!!)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initOkHttpClient() {
        val interceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.e(TAG, "OkHttp: $message") })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        if (mOkHttpClient == null) {
            synchronized(RetrofitManager::class.java) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = OkHttpClient.Builder()
                        .addInterceptor(interceptor)
//                        .addNetworkInterceptor(HttpCommonInterceptor())
                        .cookieJar(CookieJarImpl())
//                            .addInterceptor(ResponseInterceptor())
                        .retryOnConnectionFailure(true)
                        .connectTimeout(HttpPath.SOCKET_TIME_OUT, TimeUnit.SECONDS)
                        .readTimeout(HttpPath.READ_TIME_OUT, TimeUnit.SECONDS)
                        .writeTimeout(HttpPath.WRITE_TIME_OUT, TimeUnit.SECONDS)
                        .build()
                }
            }
        }
    }

    companion object {

        private val TAG = "RetrofitManager"

        private var mOkHttpClient: OkHttpClient? = null

        fun builder(baseUrl: String): Retrofit {
            return RetrofitManager(baseUrl).retrofit
        }
    }

}