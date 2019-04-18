package com.yqy.mvvm_frame

import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @desc
 * @author derekyan
 * @date 2018/5/23
 */
abstract class AbstractActivity: AppCompatActivity() , View.OnClickListener{

    protected abstract fun setContentViewBefore()

    protected abstract fun getContentViewId(): Int

    /**
     * 是否展示toolbar
     */
    protected abstract fun isShowToolbar(): Boolean

    /**
     * 初始化view
     */
    protected abstract fun initView()

    /**
     * 初始化数据
     */
    protected abstract fun initData()

    protected abstract fun onClickBack()
}