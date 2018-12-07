package com.example.zaq.kotlinframe.base

import java.io.Serializable

/**
 * 接口返回列表实体基类
 * Created by Zhang Aqi on 2018/10/11. 11:23
 * mail:1095187377@qq.com
 */
open class BaseListBean<T>(var data: MutableList<T>? = mutableListOf()) : BaseBean(), Serializable