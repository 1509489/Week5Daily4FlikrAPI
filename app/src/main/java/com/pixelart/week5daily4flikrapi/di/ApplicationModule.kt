package com.pixelart.week5daily4flikrapi.di

import android.app.Activity
import android.databinding.DataBindingUtil
import com.pixelart.week5daily4flikrapi.R
import com.pixelart.week5daily4flikrapi.base.BaseActivity
import com.pixelart.week5daily4flikrapi.ui.MainActivity
import com.pixelart.week5daily4flikrapi.ui.MainContract
import com.pixelart.week5daily4flikrapi.ui.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val baseActivity: BaseActivity<*>){
    @Provides
    fun providesMainContractPresenter(): MainContract.Presenter = MainPresenter(baseActivity as MainActivity)

}