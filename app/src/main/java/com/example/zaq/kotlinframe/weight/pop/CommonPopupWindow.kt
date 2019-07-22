package com.example.zaq.kotlinframe.weight.pop

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.PopupWindow

/**
 * Created by zaq on 2017/5/2.
 */

class CommonPopupWindow private constructor(context: Context) : PopupWindow() {
    internal val controller: PopupController = PopupController(context, this)

    override fun getWidth(): Int {
        return controller.mPopupView!!.measuredWidth
    }

    override fun getHeight(): Int {
        return controller.mPopupView!!.measuredHeight
    }

    interface ViewInterface {
        fun getChildView(view: View?, layoutResId: Int)
    }

    override fun dismiss() {
        super.dismiss()
        controller.setBackGroundLevel(1.0f)
    }

    override fun showAsDropDown(anchor: View) {
        if (Build.VERSION.SDK_INT < 24) {
            super.showAsDropDown(anchor)
        } else {
            val location = IntArray(2)
            anchor.getLocationOnScreen(location)
            showAtLocation(anchor, Gravity.NO_GRAVITY, 0, location[1] + anchor.height)
        }
    }

    fun showAsAbove(anchor: View) {
        val location = IntArray(2)
        anchor.getLocationOnScreen(location)
        showAtLocation(anchor, Gravity.NO_GRAVITY, 0, location[1] - height)
    }

    class Builder(context: Context) {
        private val params: PopupController.PopupParams = PopupController.PopupParams(context)
        private var listener: ViewInterface? = null

        /**
         * @param layoutResId 设置PopupWindow 布局ID
         * @return Builder
         */
        fun setView(layoutResId: Int): Builder {
            params.mView = null
            params.layoutResId = layoutResId
            return this
        }

        /**
         * @param view 设置PopupWindow布局
         * @return Builder
         */
        fun setView(view: View): Builder {
            params.mView = view
            params.layoutResId = 0
            return this
        }

        /**
         * 设置子View
         *
         * @param listener ViewInterface
         * @return Builder
         */
        fun setViewOnclickListener(listener: ViewInterface): Builder {
            this.listener = listener
            return this
        }

        /**
         * 设置宽度和高度 如果不设置 默认是wrap_content
         *
         * @param width 宽
         * @return Builder
         */
        fun setWidthAndHeight(width: Int, height: Int): Builder {
            params.mWidth = width
            params.mHeight = height
            return this
        }

        /**
         * 设置背景灰色程度
         *
         * @param level 0.0f-1.0f
         * @return Builder
         */
        fun setBackGroundLevel(level: Float): Builder {
            params.isShowBg = true
            params.bg_level = level
            return this
        }

        /**
         * 是否可点击Outside消失
         *
         * @param touchable 是否可点击
         * @return Builder
         */
        fun setOutsideTouchable(touchable: Boolean): Builder {
            params.isTouchable = touchable
            return this
        }

        /**
         * 设置动画
         *
         * @return Builder
         */
        fun setAnimationStyle(animationStyle: Int): Builder {
            params.isShowAnim = true
            params.animationStyle = animationStyle
            return this
        }

        fun create(): CommonPopupWindow {
            val popupWindow = CommonPopupWindow(params.mContext)
            params.apply(popupWindow.controller)
            if (listener != null && params.layoutResId != 0) {
                listener!!.getChildView(popupWindow.controller.mPopupView, params.layoutResId)
            }
            measureWidthAndHeight(popupWindow.controller.mPopupView!!)
            return popupWindow
        }

        /**
         * 测量View的宽高
         *
         * @param view View
         */
        private fun measureWidthAndHeight(view: View) {
            val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            view.measure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
