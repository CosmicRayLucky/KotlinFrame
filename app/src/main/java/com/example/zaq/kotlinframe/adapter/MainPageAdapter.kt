package com.example.zaq.kotlinframe.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Zhang Aqi on 2018/9/3. 17:41
 * mail:1095187377@qq.com
 */
class MainPageAdapter(fm: FragmentManager, private val fragments: List<Fragment>?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = fragments!![position]

    override fun getCount(): Int = fragments?.size ?: 0
}
