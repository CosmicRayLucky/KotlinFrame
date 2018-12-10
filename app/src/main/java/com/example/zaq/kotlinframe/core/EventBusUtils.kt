package com.example.zaq.kotlinframe.core


import com.example.zaq.kotlinframe.entity.ActionEvent
import org.greenrobot.eventbus.EventBus


/**
 * 广播Utils
 * Created by zaq on 2017/3/3.
 */

object EventBusUtils {

    /**
     * 发送粘性广播
     *
     * @param eventType
     */
    fun postActionStickyEvent(eventType: Int) {
        val event = ActionEvent()
        event.eventType = eventType
        EventBus.getDefault().postSticky(event)
    }

    /**
     * 发送普通广播
     *
     * @param eventType
     */
    fun postActionEvent(eventType: Int) {
        val event = ActionEvent()
        event.eventType = eventType
        EventBus.getDefault().post(event)
    }

    fun sendEnevent(o: Any) {
        EventBus.getDefault().post(o)
    }
}
