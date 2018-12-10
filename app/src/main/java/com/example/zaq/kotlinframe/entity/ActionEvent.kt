package com.example.zaq.kotlinframe.entity

import java.io.Serializable

/**
 * EventBus
 * Created by zaq on 2017/3/3.
 */

class ActionEvent : Serializable {


    var eventType: Int = 0


    /**
     * 10001------通知HomeFragment刷新房源信息
     * 10002------接收到好友添加请求，通知好友列表展示未读小红点
     */
    object EventCode {
        val CODE_10001 = 10001
        val CODE_10002 = 10002
        val CODE_10003 = 10003
        val CODE_10004 = 10004
        val CODE_10005 = 10005
        val CODE_10006 = 10006
        val CODE_10007 = 10007
        val CODE_10008 = 10008
    }

}
