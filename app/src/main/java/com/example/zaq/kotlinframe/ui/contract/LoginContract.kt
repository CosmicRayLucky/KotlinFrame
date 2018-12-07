package com.example.zaq.kotlinframe.ui.contract

import com.example.zaq.kotlinframe.base.BasePresenter
import com.example.zaq.kotlinframe.base.IModel
import com.example.zaq.kotlinframe.base.IView

/**
 * Created by Zhang Aqi on 2018/12/6. 14:30
 * mail:1095187377@qq.com
 */
interface LoginContract {

    interface View : IView {
        fun setMsg(msg: String)
    }

    interface Model : IModel {

    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun login()
    }
}