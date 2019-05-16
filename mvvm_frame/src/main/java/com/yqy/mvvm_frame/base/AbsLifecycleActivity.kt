package com.yqy.mvvm_frame.base


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.yqy.mvvm_frame.TUtil

/**
 * @desc
 * @author derekyan
 * @date 2019-05-13
 */
abstract class AbsLifecycleActivity<T : BaseViewModel<*>>: BaseActivity() {

    protected var mViewModel: T? = null


    override fun initView() {
        mViewModel = VMProviders(this, TUtil.getInstance(this, 0));
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
    protected fun <T : ViewModel> VMProviders(activity: BaseActivity, modelClass: Class<T>): T {
        return ViewModelProviders.of(activity).get(modelClass)
    }
}