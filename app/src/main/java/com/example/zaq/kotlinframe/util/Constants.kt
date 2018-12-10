package com.example.zaq.kotlinframe.util

/**
 * Created by Zhang Aqi on 2018/8/27. 17:09
 * mail:1095187377@qq.com
 */
object Constants {
    const val TAG = "HuanZu"
    /**
     * 网络请求失败Toast提示内容
     */
    const val TOAST_ERROR_MSG = "网络错误，请稍后重试"
    /**
     * 默认的UserId
     */
    const val USER_ID_DEFAULT = ""
    /**
     * 默认的IdToken
     */
    const val ID_TOKEN_DEFAULT = ""
    /**
     * 默认的openId
     */
    const val OPEN_ID_DEFAULT = ""

    /**
     * 屏幕变暗默认值
     */
    const val WINDOW_DARK_LEVEL = 0.6f

    object ResponseCode {
        // 请求成功
        const val SUCCESS_CODE = 200
        // 网络异常
        const val NET_ERROR_CODE = 400
        // 服务器错误
        const val INTERNAL_SERVER_ERROR = 500
    }
}