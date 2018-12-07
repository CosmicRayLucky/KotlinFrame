package com.example.zaq.kotlinframe.api.interceptor


import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import org.json.JSONException
import org.json.JSONObject
import java.io.EOFException
import java.io.IOException
import java.nio.charset.Charset

/**
 * 响应拦截器  未完成
 * Created by zaq on 2017/7/25.
 */

class ResponseInterceptor
//    : Interceptor
{
//    @Throws(IOException::class)
//    override fun intercept(chain: Interceptor.Chain): Response {
//        //该请求的request对象
//        val request = chain.request()
//        //真正的Response对象
//        val response = chain.proceed(request)
//        //获取Response结果
//        val string = readResponseStr(response)
//
//        val jsonObject: JSONObject
//        try {
//            jsonObject = JSONObject(string)
//            val Code = jsonObject.optInt("Code")
//            when (Code) {
//                SUCCESS_CODE//成功
//                -> Log.e(Constants.LOG_TAG, "到这里已经成功")
//                EMPTY_CODE//空数据处理
//                -> Log.e(Constants.LOG_TAG, "这是一个空的数据")
//                PARAM_ERROR_CODE//参数错误处理
//                -> Log.e(Constants.LOG_TAG, "这是一个参数错误的数据")
//                PARAM_FORMAT_ERROR_CODE//参数格式错误处理
//                -> Log.e(Constants.LOG_TAG, "这是一个参数格式不正确的数据")
//                TOKEN_ERROR_CODE//Token失效处理
//                -> Log.e(Constants.LOG_TAG, "Token已失效")
//            }//                    AlertDialog.Builder builder = new AlertDialog.Builder(TechnologyEasierApplication.getContext());
//            //                    builder.setTitle("前往登录");
//            //                    builder.setMessage("登录身份已过期，请重新登录");
//            //                    builder.setPositiveButton("前往登陆", new DialogInterface.OnClickListener() {
//            //                        @Override
//            //                        public void onClick(DialogInterface dialog, int which) {
//            //                            TechnologyEasierApplication.getContext().startActivity(new Intent(TechnologyEasierApplication.getContext(), LoginActivity.class));
//            //                            dialog.dismiss();
//            //                        }
//            //                    });
//            ////                    builder.setNegativeButton("", null);
//            //                    AlertDialog dialog = builder.create();
//            //                    dialog.show();
//            //                    Intent intent = new Intent(AppContextUtil.INSTANCE.getInstance(), LoginActivity.class);
//            //                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            //                    AppContextUtil.INSTANCE.getInstance().startActivity(intent);
//
//            //            重构Request请求
//            //            Request newRequest = request.newBuilder().build();
//            //拿新的结果进行返回
//            //            response = chain.proceed(request);
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return response
//    }
//
//    /**
//     * 读取Response返回String内容
//     *
//     * @param response
//     * @return
//     */
//    private fun readResponseStr(response: Response): String? {
//        val body = response.body()
//        val source = body!!.source()
//        try {
//            source.request(java.lang.Long.MAX_VALUE)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return null
//        }
//
//        val contentType = body.contentType()
//        var charset: Charset? = Charset.forName("UTF-8")
//        if (contentType != null) {
//            charset = contentType.charset(charset)
//        }
//        var s: String? = null
//        val buffer = source.buffer()
//        if (isPlaintext(buffer)) {
//            s = buffer.clone().readString(charset!!)
//        }
//        return s
//    }
//
//    /**
//     * 自定义Response对象，装载Chain和Response
//     */
//    class CustomResponse(var response: Response, var chain: Interceptor.Chain)
//
//    companion object {
//
//        internal fun isPlaintext(buffer: Buffer): Boolean {
//            try {
//                val prefix = Buffer()
//                val byteCount = if (buffer.size() < 64) buffer.size() else 64
//                buffer.copyTo(prefix, 0, byteCount)
//                for (i in 0..15) {
//                    if (prefix.exhausted()) {
//                        break
//                    }
//                    val codePoint = prefix.readUtf8CodePoint()
//                    if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
//                        return false
//                    }
//                }
//                return true
//            } catch (e: EOFException) {
//                return false // Truncated UTF-8 sequence.
//            }
//
//        }
//    }
}
