package com.example.zaq.kotlinframe.base

/**
 * 定义Presenter层的接口
 * Created by Zhang Aqi on 2018/12/6. 15:45
 * mail:1095187377@qq.com
 */
interface IPresenter<V : IView> {
    /**
     * 绑定视图
     *
     * @param view
     */
    fun attachView(view: V)

    /**
     * 解除绑定（每个V记得使用完之后解绑，主要是用于防止内存泄漏问题）
     */
    fun detachView()
}