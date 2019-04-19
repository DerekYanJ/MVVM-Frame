package com.yqy.mvvm_frame

/**
 * @desc 用于发生错误后传递给UI解析
 * @author derekyan
 * @date 2018/5/23
 */
data class YError(val code: Int, val msg: String): RuntimeException(msg)