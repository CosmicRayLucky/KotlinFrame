package com.example.zaq.kotlinframe.core

import android.annotation.SuppressLint
import android.widget.Toast
import com.example.zaq.kotlinframe.App

/**
 * Created by zaq on 2017/8/22
 */

object ToastUtil {

    private var toast: Toast? = null

    @SuppressLint("ShowToast")
    fun showToast(content: CharSequence) {
        //连续Toast时，会立即显示最新的Toast。
        if (toast == null) {
            toast = Toast.makeText(App.sAppContext, content, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(content)
        }
        toast!!.show()
    }
}
