package com.example.zaq.kotlinframe.weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View

@SuppressLint("DuplicateDivider")
/**
 * 万能分割线
 * Created by zaq on 2017/9/15.
 */

class DividerItemDecoration : RecyclerView.ItemDecoration {
    private var mPaint: Paint? = null
    //取名mDivider似乎更恰当
    private var mDrawable: Drawable? = null
    //分割线高度，默认为1px
    private var mDividerHeight = 1
    //列表的方向
    private var mOrientation: Int = 0


    /**
     * 默认分割线：高度为2px，颜色为灰色
     *
     * @param context     上下文
     * @param orientation 列表方向
     */
    constructor(context: Context, orientation: Int) {
        this.setOrientation(orientation)
        //获取xml配置的参数
        val a = context.obtainStyledAttributes(ATTRS)
        //typedArray.getDrawable(attr)这句是说我们可以通过我们的资源获得资源，使用我们的资源名attr去获得资源id
        //看不懂就用自己写一个分割线的图片吧，方法：ContextCompat.getDrawable(context, drawableId);
        mDrawable = a.getDrawable(0)
        //官方的解释是：回收TypedArray，以便后面重用。在调用这个函数后，你就不能再使用这个TypedArray。
        //在TypedArray后调用recycle主要是为了缓存。
        a.recycle()
    }

    /**
     * 自定义分割线
     *
     * @param context     上下文
     * @param orientation 列表方向
     * @param drawableId  分割线图片
     */
    constructor(context: Context, orientation: Int, drawableId: Int) {
        this.setOrientation(orientation)
        //旧的getDrawable方法弃用了，这个是新的
        mDrawable = ContextCompat.getDrawable(context, drawableId)
        mDividerHeight = mDrawable!!.intrinsicHeight
    }

    /**
     * 自定义分割线
     *
     * @param context       上下文
     * @param orientation   列表方向
     * @param dividerHeight 分割线高度
     * @param dividerColor  分割线颜色
     */
    constructor(
        context: Context, orientation: Int,
        dividerHeight: Int, dividerColor: Int
    ) {
        this.setOrientation(orientation)
        mDividerHeight = dividerHeight
        //抗锯齿画笔
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.color = dividerColor
        //填满颜色
        mPaint!!.style = Paint.Style.FILL
    }

    /**
     * 设置方向
     *
     * @param orientation
     */
    fun setOrientation(orientation: Int) {
        if (orientation < 0 || orientation > 2)
            throw IllegalArgumentException("invalid orientation")
        mOrientation = orientation
    }


    /**
     * 绘制分割线之后,需要留出一个外边框,就是说item之间的间距要换一下
     *
     * @param outRect outRect.set(0, 0, 0, 0);的四个参数理解成margin就好了
     * @param view    视图
     * @param parent  父级view
     * @param state
     */
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        //下面super...代码其实调用的就是那个过时的getItemOffsets,也就是说这个方法体内容也可以通通移到那个过时的getItemOffsets中
        super.getItemOffsets(outRect, view, parent, state)
        //获取layoutParams参数
        val layoutParams = view.layoutParams as RecyclerView.LayoutParams
        //当前位置
        val itemPosition = layoutParams.viewLayoutPosition
        parent.adapter ?: return
        //ItemView数量
        var childCount = parent.adapter!!.itemCount
        when (mOrientation) {
            BOTH_SET -> {
                //获取Layout的相关参数
                val spanCount = this.getSpanCount(parent)
                when {
                    isLastRaw(parent, itemPosition, spanCount, childCount) -> // 如果是最后一行，则不需要绘制底部
                        outRect.set(0, 0, mDividerHeight, 0)
                    isLastColum(parent, itemPosition, spanCount, childCount) -> // 如果是最后一列，则不需要绘制右边
                        outRect.set(0, 0, 0, mDividerHeight)
                    else -> outRect.set(0, 0, mDividerHeight, mDividerHeight)
                }
            }
            VERTICAL_LIST -> {
                childCount -= 1
                //水平布局右侧留Margin,如果是最后一列,就不要留Margin了
                outRect.set(0, 0, if (itemPosition != childCount) mDividerHeight else 0, 0)
            }
            HORIZONTAL_LIST -> {
                childCount -= 1
                //垂直布局底部留边，最后一行不留
                outRect.set(0, 0, 0, if (itemPosition != childCount) mDividerHeight else 0)
            }
        }
    }

    /**
     * 绘制分割线
     *
     * @param c
     * @param parent
     * @param state
     */
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        when (mOrientation) {
            VERTICAL_LIST -> drawVertical(c, parent)
            HORIZONTAL_LIST -> drawHorizontal(c, parent)
            else -> {
                drawHorizontal(c, parent)
                drawVertical(c, parent)
            }
        }
    }

    /**
     * 绘制横向 item 分割线
     *
     * @param canvas 画布
     * @param parent 父容器
     */
    private fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {
        val x = parent.paddingLeft
        val width = parent.measuredWidth - parent.paddingRight
        //getChildCount()(ViewGroup.getChildCount) 返回的是显示层面上的“所包含的子 View 个数”。
        val childSize = parent.childCount
        for (i in 0 until childSize) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            //item底部的Y轴坐标+margin值
            val y = child.bottom + layoutParams.bottomMargin
            val height = y + mDividerHeight
            if (mDrawable != null) {
                //setBounds(x,y,width,height); x:组件在容器X轴上的起点 y:组件在容器Y轴上的起点
                // width:组件的长度 height:组件的高度
                mDrawable!!.setBounds(x, y, width, height)
                mDrawable!!.draw(canvas)
            }
            if (null != mPaint) {
                canvas.drawRect(x.toFloat(), y.toFloat(), width.toFloat(), height.toFloat(), mPaint)
            }
        }
    }

    /**
     * 绘制纵向 item 分割线
     *
     * @param canvas
     * @param parent
     */
    private fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.measuredHeight - parent.paddingBottom
        val childSize = parent.childCount
        for (i in 0 until childSize) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val left = child.right + layoutParams.rightMargin
            val right = left + mDividerHeight
            if (mDrawable != null) {
                mDrawable!!.setBounds(left, top, right, bottom)
                mDrawable!!.draw(canvas)
            }
            if (mPaint != null) {
                canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
            }
        }
    }


    /**
     * 获取列数
     *
     * @param parent
     * @return
     */
    private fun getSpanCount(parent: RecyclerView): Int {
        var spanCount = -1
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            spanCount = layoutManager.spanCount
        } else if (layoutManager is StaggeredGridLayoutManager) {
            spanCount = layoutManager
                .spanCount
        }
        return spanCount
    }


    private fun isLastColum(
        parent: RecyclerView, pos: Int, spanCount: Int,
        childCount: Int
    ): Boolean {
        var childCount = childCount
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            val orientation = layoutManager
                .orientation
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                // 如果是最后一列，则不需要绘制右边
                if ((pos + 1) % spanCount == 0)
                    return true
            } else {
                childCount -= childCount % spanCount
                // 如果是最后一列，则不需要绘制右边
                if (pos >= childCount)
                    return true
            }
        } else if (layoutManager is StaggeredGridLayoutManager) {
            val orientation = layoutManager
                .orientation
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                // 如果是最后一列，则不需要绘制右边
                if ((pos + 1) % spanCount == 0)
                    return true
            } else {
                childCount -= childCount % spanCount
                // 如果是最后一列，则不需要绘制右边
                if (pos >= childCount)
                    return true
            }
        }
        return false
    }

    private fun isLastRaw(
        parent: RecyclerView, pos: Int, spanCount: Int,
        childCount: Int
    ): Boolean {
        var childCount = childCount
        val orientation: Int
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            childCount -= childCount % spanCount
            orientation = layoutManager
                .orientation
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                // 如果是最后一行，则不需要绘制底部
                childCount -= childCount % spanCount
                if (pos >= childCount)
                    return true
            } else {// StaggeredGridLayoutManager 横向滚动
                // 如果是最后一行，则不需要绘制底部
                if ((pos + 1) % spanCount == 0)
                    return true
            }
        } else if (layoutManager is StaggeredGridLayoutManager) {
            orientation = layoutManager
                .orientation
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                // 如果是最后一行，则不需要绘制底部
                childCount -= childCount % spanCount
                if (pos >= childCount)
                    return true
            } else {// StaggeredGridLayoutManager 横向滚动
                // 如果是最后一行，则不需要绘制底部
                if ((pos + 1) % spanCount == 0)
                    return true
            }
        }
        return false
    }

    companion object {
        //系统自带的参数
        private val ATTRS = intArrayOf(android.R.attr.listDivider)
        //水平
        val HORIZONTAL_LIST = RecyclerView.HORIZONTAL
        //垂直
        val VERTICAL_LIST = RecyclerView.VERTICAL
        //水平+垂直
        val BOTH_SET = 2
    }
}
