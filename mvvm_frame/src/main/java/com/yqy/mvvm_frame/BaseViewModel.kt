package com.yqy.mvvm_frame

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel



/**
 * @desc
 * @author derekyan
 * @date 2019/4/17
 */
class BaseViewModel<T: BaseRepository> : AndroidViewModel {
    var mRepository: T? = null

    constructor(application: Application): super(application) {
        Log.e("BaseViewModel", "constructor run")
        mRepository = TUtil.getNewInstance(this, 0)
    }


    override fun onCleared() {
        super.onCleared()
        mRepository?.unDisposable()
    }

}