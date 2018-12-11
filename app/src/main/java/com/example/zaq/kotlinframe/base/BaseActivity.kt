package com.example.zaq.kotlinframe.base

import android.os.Bundle
import com.example.zaq.kotlinframe.core.ActivityCollector
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Activity基类
 * Created by Zhang Aqi on 2018/12/6. 14:02
 * mail:1095187377@qq.com
 */
abstract class BaseActivity<V : IView, P : BasePresenter<V>> : RxAppCompatActivity() {
    private lateinit var mPresenter: P
    private lateinit var mView: V

    fun getPresenter() = mPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        mPresenter = createPresenter()
        mView = createView()
        mPresenter.attachView(mView)

        ActivityCollector.addActivity(this, javaClass)

        afterCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun createPresenter(): P
    protected abstract fun createView(): V
    protected abstract fun afterCreate()
}