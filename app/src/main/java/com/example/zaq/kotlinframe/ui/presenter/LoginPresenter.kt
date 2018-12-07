package com.example.zaq.kotlinframe.ui.presenter

import android.content.Context
import com.example.zaq.kotlinframe.ui.contract.LoginContract
import com.example.zaq.kotlinframe.ui.model.LoginModel

/**
 * Created by Zhang Aqi on 2018/12/6. 14:34
 * mail:1095187377@qq.com
 */
class LoginPresenter constructor(val context: Context) : LoginContract.Presenter() {

    init {
        var loginModel = LoginModel()
    }

    override fun login() {

    }
}