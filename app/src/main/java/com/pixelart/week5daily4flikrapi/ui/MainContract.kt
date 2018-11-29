package com.pixelart.week5daily4flikrapi.ui

import com.pixelart.week5daily4flikrapi.base.BasePresenter
import com.pixelart.week5daily4flikrapi.base.BaseView
import com.pixelart.week5daily4flikrapi.models.Photos

interface MainContract {
    interface View: BaseView{
        fun shoPhotos(photos: List<Photos>)
        fun showProgressBar()
        fun hideProgressBar()
        fun startDetailScreen()
    }

    interface Presenter: BasePresenter{
        fun onSuccess(photos: List<Photos>)
    }
}