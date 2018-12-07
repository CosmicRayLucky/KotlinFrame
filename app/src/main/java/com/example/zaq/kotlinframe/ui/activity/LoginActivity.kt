package com.example.zaq.kotlinframe.ui.activity

import com.example.zaq.kotlinframe.R
import com.example.zaq.kotlinframe.base.BaseActivity
import com.example.zaq.kotlinframe.ui.contract.LoginContract
import com.example.zaq.kotlinframe.ui.presenter.LoginPresenter

/**
 * Created by Zhang Aqi on 2018/12/6. 14:29
 * mail:1095187377@qq.com
 */
class LoginActivity : BaseActivity<LoginContract.View, LoginContract.Presenter>(), LoginContract.View {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun createPresenter(): LoginContract.Presenter = LoginPresenter(this)

    override fun createView(): LoginContract.View = this

    override fun afterCreate() {

    }

    override fun setMsg(msg: String) {

    }
}