package com.example.zaq.kotlinframe.ui.presenter

import android.content.Context
import com.example.zaq.kotlinframe.ui.contract.LoginActivityC
import com.example.zaq.kotlinframe.ui.model.LoginActivityM

/**
 * Created by Zhang Aqi on 2018/12/6. 14:34
 * mail:1095187377@qq.com
 */
class LoginActivityP constructor(val context: Context) : LoginActivityC.Presenter() {

    private val loginModel = LoginActivityM()

    override fun login() {

    }
}