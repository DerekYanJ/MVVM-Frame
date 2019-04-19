package com.yqy.mvvm_frame

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders


/**
 * @desc
 * @author derekyan
 * @date 2019/4/19
 */
abstract class AbsLifecycleFragment<T : BaseViewModel<*>>: BaseFragment() {
    protected var mViewModel: T? = null

    override fun initView(savedInstanceState: Bundle?, view: View) {
        mViewModel = VMProviders(this, TUtil.getInstance(this, 0))
        if (null != mViewModel) {
            dataObserver()
        }
    }


    protected fun dataObserver() {

    }

    /**
     * 获取网络数据
     */
    protected fun getRemoteData() {

    }

    /**
     * create ViewModelProviders
     *
     * @return ViewModel
     */
    protected fun <T : ViewModel> VMProviders(fragment: BaseFragment, modelClass: Class<T>): T {
        return ViewModelProviders.of(fragment).get(modelClass)
    }
}