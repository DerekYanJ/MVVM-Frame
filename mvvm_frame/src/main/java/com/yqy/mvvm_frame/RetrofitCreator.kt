package com.yqy.mvvm_frame

import android.text.TextUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

/**
 * @desc
 * @author derekyan
 * @date 2019/4/19
 */
class RetrofitCreator private constructor() {
    private var retrofit: Retrofit? = null
    private val timeout = 60L

    companion object {
        val instance: RetrofitCreator
            get() = RetrofitHolder.INSTANCE
    }

    private object RetrofitHolder {
        internal var INSTANCE = RetrofitCreator()
    }
    init {
        val okHttpClientBuilder = OkHttpClient.Builder()

        if(YCore.getConfigs(YConfigurator.ConfigKeys.IS_SHOW_LOG) as Boolean) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }

        val okHttpClient = okHttpClientBuilder
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(YCore.getConfigs(YConfigurator.ConfigKeys.BASE_URL) as String)
            .addConverterFactory(CustomGsonConvertFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun getApiService(baseUrl: String, clazz: Class<*>): Any {
        if (TextUtils.isEmpty(baseUrl)) {
            throw IllegalArgumentException("baseUrl不能为空")
        } else if (!clazz.isInterface) {
            throw IllegalArgumentException("请传入接口类型！")
        }

        retrofit = retrofit!!.newBuilder().baseUrl(baseUrl).build()
        return retrofit!!.create(clazz)
    }
}