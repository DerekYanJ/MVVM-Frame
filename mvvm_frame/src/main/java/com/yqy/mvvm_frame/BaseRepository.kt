package com.yqy.mvvm_frame

import com.yqy.mvvm_frame.net.ApiService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable




/**
 * @desc
 * @author derekyan
 * @date 2019/4/19
 */
abstract class BaseRepository {
    protected var apiService: ApiService? = null

    constructor(): super() {
        if (null == apiService) {
//            apiService = ApiService()
        }
    }


    private var mCompositeDisposable: CompositeDisposable? = null


    protected fun addDisposable(disposable: Disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable?.add(disposable)
    }

    fun unDisposable() {
        if (mCompositeDisposable != null && mCompositeDisposable?.isDisposed!!) {
            mCompositeDisposable?.clear()
        }
    }

}