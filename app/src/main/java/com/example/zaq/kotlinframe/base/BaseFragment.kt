package com.example.zaq.kotlinframe.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.components.support.RxFragment


/**
 * Fragment基类
 * Created by Zhang Aqi on 2018/12/6. 14:03
 * mail:1095187377@qq.com
 */
abstract class BaseFragment<V : IView, P : BasePresenter<V>> : RxFragment() {
    var mRootView: View? = null
    private lateinit var mPresenter: P
    private lateinit var mView: V

    fun getPresenter() = mPresenter


    private fun initRootView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mRootView = inflater.inflate(getLayoutId(), container, false)
        return mRootView
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return mRootView ?: initRootView(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = createPresenter()
        mView = createView()
        mPresenter.attachView(mView)

        afterCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.detachView()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun createPresenter(): P
    protected abstract fun createView(): V
    protected abstract fun afterCreate(savedInstanceState: Bundle?)
}