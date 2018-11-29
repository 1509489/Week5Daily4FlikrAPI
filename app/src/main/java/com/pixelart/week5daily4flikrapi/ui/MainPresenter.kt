package com.pixelart.week5daily4flikrapi.ui

import com.pixelart.week5daily4flikrapi.models.FlikrData
import com.pixelart.week5daily4flikrapi.models.Photos

class MainPresenter(private val mainView: MainContract.View): MainContract.Presenter {
    override fun onSuccess(photos: List<Photos>) {
        mainView.shoPhotos(photos)
    }

    override fun getPhotos() {

    }
}