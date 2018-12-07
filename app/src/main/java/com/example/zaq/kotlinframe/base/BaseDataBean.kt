package com.example.zaq.kotlinframe.base

import java.io.Serializable

/**
 * 接口返回单实体基类
 * Created by Zhang Aqi on 2018/12/6. 14:03
 * mail:1095187377@qq.com
 */
open class BaseDataBean<T>(var data: T? = null) : BaseBean(), Serializable
