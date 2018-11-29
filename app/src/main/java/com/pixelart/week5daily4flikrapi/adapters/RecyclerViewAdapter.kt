package com.pixelart.week5daily4flikrapi.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pixelart.week5daily4flikrapi.R
import com.pixelart.week5daily4flikrapi.models.Photos
import com.squareup.picasso.Picasso

class RecyclerViewAdapter( var photoList: List<Photos>, val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    val TAG = "RecyclerViewAdapter"
    lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerViewAdapter.ViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val photo = photoList[position]

        holder.tvTitle.text = photo.title
        Picasso.get()
            .load(photo.imagUrl)
            //.error()
            .resize(100, 100)
            .centerCrop()
            .into(holder.ivImage)
        Log.d(TAG, photo.imagUrl)

        holder.itemView.setOnClickListener {
            listener.onItemClickedListener(position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val ivImage: ImageView = itemView.findViewById(R.id.ivImage)

    }

    interface OnItemClickListener
    {
        fun onItemClickedListener(position: Int)
    }
}