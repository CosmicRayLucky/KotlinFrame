package com.example.zaq.kotlinframe.core

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by zaq on 2017/8/22
 */

abstract class CommonAdapter<T>(layoutResId: Int, data: List<T>?) : BaseQuickAdapter<T, BaseViewHolder>(layoutResId, data) {

    override fun convert(baseViewHolder: BaseViewHolder, data: T) {
        mConvert(baseViewHolder, data, baseViewHolder.adapterPosition - headerLayoutCount)
    }

    protected abstract fun mConvert(holder: BaseViewHolder, data: T, position: Int)
}
