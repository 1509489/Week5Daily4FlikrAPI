package com.pixelart.week5daily4flikrapi.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import com.pixelart.week5daily4flikrapi.models.FlikrData
import com.pixelart.week5daily4flikrapi.models.Photos
import com.pixelart.week5daily4flikrapi.remotes.RemoteHelper
import com.pixelart.week5daily4flikrapi.ui.MainContract
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseActivity<T: BasePresenter> : AppCompatActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun initData( callback: MainContract.Presenter){
        RemoteHelper.getFlikrData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<FlikrData> {
                override fun onSuccess(t: FlikrData) {
                    val photoList = ArrayList<Photos>()
                    for (i in 0 until t.items.size)
                    {
                        photoList.add(Photos("${t.items[i].media}", t.items[i].title))


                    }
                    callback.onSuccess(photoList)
                    Log.d("BaseActivity", "Size: ${t.items.size}, Link: ${t.items[0].link}, ${t.items[0].media}, ${t.items[0].title}, ${t.items[0].tags}, ${t.items[0].author}")
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })
    }

    abstract fun getViewPresenter(): T
    abstract fun init()
}