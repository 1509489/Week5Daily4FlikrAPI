package com.pixelart.week5daily4flikrapi.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photos(val imagUrl: String, val title: String):Parcelable