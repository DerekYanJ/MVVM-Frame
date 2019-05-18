package com.yqy.mvvm_frame.core

import android.content.Context

/**
 * @desc 获取配置核心类
 * @author derekyan
 * @date 2018/5/23
 */
class YCore {

    companion object {
        fun init(context: Context): YConfigurator {
            YConfigurator.getInstance()
                    .getConfigs()[YConfigurator.ConfigKeys.APPCONTEXT] = context.applicationContext
            return YConfigurator.getInstance()
        }

        public fun getConfigurator(): YConfigurator {
            return YConfigurator.getInstance()
        }

        private fun <T> getConfiguration(key: Any): T {
            return getConfigurator().getConfiguration(key)
        }

        fun getApplicationContext(): Context{
            return getConfiguration(YConfigurator.ConfigKeys.APPCONTEXT)
        }

        fun getConfigs(key: Any) = getConfigurator().getConfigs()[key]

    }

}