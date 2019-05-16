package com.yqy.mvvm_frame.base

import com.yqy.mvvm_frame.YError

/**
 * @desc
 * @author derekyan
 * @date 2018/5/23
 */
interface IBaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(error: String)

    fun showError(xcError: YError)

    fun tokenExpired()

    fun tokenExpired(msg: String)
}