/**
 *
 */
package com.example.zaq.kotlinframe.core

import android.content.Context
import android.text.TextUtils
import com.example.zaq.kotlinframe.App

import java.util.ArrayList

/**
 * SharedPreferences存储轻量级信息
 * Created by zcy on 16/7/14.
 */

object SharedPreferUtil {

    /**
     * // 清除所有属性信息
     * 1、clearAllProperties(Context context);
     *
     *
     * // 获取String型数据
     * 2、getSharedValue(Context context, String key,String defaultValue);
     *
     *
     * // 获取int型数据
     * 3、getSharedValue(Context context, String key,int defaultValue);
     *
     *
     * // 获取float型数据
     * 4、getSharedValue(Context context, String key,float defaultValue);
     *
     *
     * // 获取boolean型数据
     * 5、getSharedValue(Context context, String key,boolean defaultValue);
     *
     *
     * // 验证整数和浮点数（正负整数和正负浮点数）
     * 6、checkDecimals(String decimals);
     *
     *
     * // 保存boolean型数据
     * 7、saveSharedValue(Context context, String key,boolean value);
     *
     *
     * // 保存String型数据
     * 8、saveSharedValue(Context context, String key, String value);
     *
     *
     * // 保存int型数据
     * 9、saveSharedValue(Context context, String key, int value);
     *
     *
     * // 保存float型数据
     * 10、saveSharedValue(Context context, String key, float value);
     */


    private val PREFS_NAME = "SHAREDPREFERUTIL"

    /**
     * 清除所有属性信息
     *
     * @param context
     */
    fun clearAllProperties(context: Context): Boolean {
        val settings = context.getSharedPreferences(
            PREFS_NAME,
                Context.MODE_PRIVATE)
        return settings.edit().clear().commit()
    }

    /**
     * 获取String型数据
     *
     * @param key          键
     * @param defaultValue 默认值
     */
    fun getSharedValue(key: String,
                       defaultValue: String): String {
        val perferenceObjInfo = App.sAppContext.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE)
        var value = perferenceObjInfo.getString(key, defaultValue)
        if (value == null || "" == value) {
            value = defaultValue
        }
        return value
    }

    /**
     * 获取int型数据
     *
     * @param key          键
     * @param defaultValue 默认值
     */
    fun getSharedValue(key: String,
                       defaultValue: Int): Int {
        val perferenceObjInfo = App.sAppContext.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE)
        return perferenceObjInfo.getInt(key, defaultValue)
    }

    /**
     * 获取float型数据
     *
     * @param key          键
     * @param defaultValue 默认值
     */
    fun getSharedValue(key: String,
                       defaultValue: Float): Float {
        val perferenceObjInfo = App.sAppContext.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE)
        return perferenceObjInfo.getFloat(key, defaultValue)
    }

    /**
     * 获取boolean型数据
     *
     * @param key          键
     * @param defaultValue 默认值
     */
    fun getSharedValue(key: String,
                       defaultValue: Boolean): Boolean {
        val perferenceObjInfo = App.sAppContext.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE)
        return perferenceObjInfo.getBoolean(key, defaultValue)
    }

    /**
     * 保存boolean型数据
     *
     * @param key   键
     * @param value 值
     */
    fun saveSharedValue(key: String,
                        value: Boolean) {
        val perference = App.sAppContext.getSharedPreferences(
            PREFS_NAME,
                Context.MODE_PRIVATE)
        val editor = perference.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * 保存String型数据
     *
     * @param key   键
     * @param value 值
     */
    fun saveSharedValue(key: String, value: String) {
        val perference = App.sAppContext.getSharedPreferences(
            PREFS_NAME,
                Context.MODE_PRIVATE)
        val editor = perference.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * 保存int型数据
     *
     * @param key   键
     * @param value 值
     */
    fun saveSharedValue(key: String, value: Int) {
        val perference = App.sAppContext.getSharedPreferences(
            PREFS_NAME,
                Context.MODE_PRIVATE)
        val editor = perference.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**
     * 保存float型数据
     *
     * @param key   键
     * @param value 值
     */
    fun saveSharedValue(key: String, value: Float) {
        val perference = App.sAppContext.getSharedPreferences(
            PREFS_NAME,
                Context.MODE_PRIVATE)
        val editor = perference.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    /**
     * 清除部分属性信息
     */
    fun clearProperties(vararg keys: String): Boolean {
        val settings = App.sAppContext.getSharedPreferences(
            PREFS_NAME,
                Context.MODE_PRIVATE)
        val editor = settings.edit()
        for (key in keys) {
            editor.remove(key)
        }
        return editor.commit()
    }

    /**
     * 保留部分属性信息 清除其余属性
     */
    fun keepProperties(vararg keys: String): Boolean {
        val settings = App.sAppContext.getSharedPreferences(
            PREFS_NAME,
                Context.MODE_PRIVATE)
        val spMap = settings.all
        val keyList = ArrayList<String>()
        for ((key) in spMap) {
            keyList.add(key)
        }
        val editor = settings.edit()
        for (key in keyList) {
            var isDelete = true
            for (k in keys) {
                if (TextUtils.equals(k, key)) {
                    isDelete = false
                    break
                }
            }
            if (isDelete) {
                editor.remove(key)
            }
        }
        return editor.commit()
    }

    object Keys {
        const val LAT = "latitude"
        const val LNG = "longitude"
        const val ID_TOKEN = "IdToken"
        const val RONG_TOKEN = "rongToken"
        const val RONG_USER_ID = "rongUserId"
        const val USER_ID = "userId"
        const val AVATAR = "avatar"
        const val IS_FIRST_LOGIN = "isFirstLogin"
        const val IS_LOGIN = "isLogin"
        const val GENDER = "gender"
        const val RESIDENT_ADDRESS = "residentAddress"
        const val RESIDENT_LAT = "residentLat"
        const val RESIDENT_LNG = "residentLng"
        const val DEST_ADDRESS = "destAddress"
        const val DEST_LAT = "destLat"
        const val DEST_LNG = "destLng"
        const val RANGE = "range"
        const val OPEN_ID = "openId"
        const val PHONE = "phone"
        const val OPEN_TYPE = "openType"
        const val MONEY = "money"
        const val NOTE = "note"
        const val EXT2 = "ext2"
        const val EXT3 = "ext3"
        const val NICK_NAME = "nickName"

        const val NOW_LAT = "nowLatitude"
        const val NOW_LNG = "nowLongitude"
        const val WANT_LAT = "wantLatitude"
        const val WANT_LNG = "wantLongitude"

    }

}
