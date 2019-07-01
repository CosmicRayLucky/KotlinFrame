package com.example.zaq.kotlinframe.ui.activity

import com.example.zaq.kotlinframe.R
import com.example.zaq.kotlinframe.base.BaseActivity
import com.example.zaq.kotlinframe.ui.contract.LoginActivityC
import com.example.zaq.kotlinframe.ui.presenter.LoginActivityP

/**
 * Created by Zhang Aqi on 2018/12/6. 14:29
 * mail:1095187377@qq.com
 */
class LoginActivity : BaseActivity<LoginActivityC.View, LoginActivityC.Presenter>(), LoginActivityC.View {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun createPresenter(): LoginActivityC.Presenter = LoginActivityP(this)

    override fun createView(): LoginActivityC.View = this

    override fun afterCreate() {

    }

    override fun setMsg(msg: String) {

    }
}