package com.yqy.mvvm_frame

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