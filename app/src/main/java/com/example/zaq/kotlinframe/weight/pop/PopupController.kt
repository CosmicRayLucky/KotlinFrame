package com.example.zaq.kotlinframe.weight.pop

import android.app.Activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.*
import android.widget.PopupWindow

/**
 * Created by zaq on 2017/5/2.
 */

internal class PopupController(private val context: Context, private val popupWindow: PopupWindow) {
    private var layoutResId: Int = 0//布局id
    var mPopupView: View? = null//弹窗布局View
    private var mView: View? = null
    private var mWindow: Window? = null

    fun setView(layoutResId: Int) {
        mView = null
        this.layoutResId = layoutResId
        installContent()
    }

    fun setView(view: View) {
        mView = view
        this.layoutResId = 0
        installContent()
    }

    private fun installContent() {
        if (layoutResId != 0) {
            mPopupView = LayoutInflater.from(context).inflate(layoutResId, null)
        } else if (mView != null) {
            mPopupView = mView!!
        }
        popupWindow.contentView = mPopupView
    }

    /**
     * 设置宽度
     *
     * @param width  宽
     * @param height 高
     */
    private fun setWidthAndHeight(width: Int, height: Int) {
        if (width == 0 || height == 0) {
            //如果没设置宽高，默认是WRAP_CONTENT
            popupWindow.width = ViewGroup.LayoutParams.WRAP_CONTENT
            popupWindow.height = ViewGroup.LayoutParams.WRAP_CONTENT
        } else {
            popupWindow.width = width
            popupWindow.height = height
        }
    }


    /**
     * 设置背景灰色程度
     *
     * @param level 0.0f-1.0f
     */
    fun setBackGroundLevel(level: Float) {
        mWindow = (context as Activity).window
        val params = mWindow!!.attributes
        params.alpha = level
        mWindow!!.attributes = params
    }


    /**
     * 设置动画
     */
    private fun setAnimationStyle(animationStyle: Int) {
        popupWindow.animationStyle = animationStyle
    }

    /**
     * 设置Outside是否可点击
     *
     * @param touchable 是否可点击
     */
    private fun setOutsideTouchable(touchable: Boolean) {
        popupWindow.setBackgroundDrawable(ColorDrawable(0x00000000))//设置透明背景
        popupWindow.isOutsideTouchable = touchable//设置outside可点击
        popupWindow.isFocusable = touchable
    }


    internal class PopupParams(var mContext: Context) {
        var layoutResId: Int = 0//布局id
        var mWidth: Int = 0
        var mHeight: Int = 0//弹窗的宽和高
        var isShowBg: Boolean = false
        var isShowAnim: Boolean = false
        var bg_level: Float = 0.toFloat()//屏幕背景灰色程度
        var animationStyle: Int = 0//动画Id
        var mView: View? = null
        var isTouchable = true

        fun apply(controller: PopupController) {
            when {
                mView != null -> controller.setView(mView!!)
                layoutResId != 0 -> controller.setView(layoutResId)
                else -> throw IllegalArgumentException("PopupView's contentView is null")
            }
            controller.setWidthAndHeight(mWidth, mHeight)
            controller.setOutsideTouchable(isTouchable)//设置outside可点击
            if (isShowBg) {
                //设置背景
                controller.setBackGroundLevel(bg_level)
            }
            if (isShowAnim) {
                controller.setAnimationStyle(animationStyle)
            }
        }
    }
}
