package com.yqy.mvvm_frame

/**
 * @desc
 * @author derekyan
 * @date 2019/4/19
 */
data class ApiResponse<T>(val code: Int, var msg: String, val body: T, val message: String)