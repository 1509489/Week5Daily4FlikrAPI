package com.pixelart.week5daily4flikrapi.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.pixelart.week5daily4flikrapi.R
import com.pixelart.week5daily4flikrapi.adapters.RecyclerViewAdapter
import com.pixelart.week5daily4flikrapi.base.BaseActivity
import com.pixelart.week5daily4flikrapi.models.Photos
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainContract.Presenter>(), MainContract.View, RecyclerViewAdapter.OnItemClickListener {


    private val TAG = "MainActivity"

    lateinit var layoutManager:GridLayoutManager
    lateinit var adapter: RecyclerViewAdapter

    @Inject
    lateinit var presenter:MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

    }

    override fun getViewPresenter(): MainContract.Presenter = presenter

    override fun init() {

    }

    override fun shoPhotos(photos: List<Photos>) {
        adapter = RecyclerViewAdapter(photos,this)
        recyclerView.adapter = adapter
    }
    override fun onItemClickedListener(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun showProgressBar() {

    }

    override fun hideProgressBar() {

    }

    override fun startDetailScreen() {

    }

    override fun showMessage(message: String) {

    }

    override fun showError(error: String) {

    }



}
