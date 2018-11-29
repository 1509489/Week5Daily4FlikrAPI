package com.pixelart.week5daily4flikrapi.models



data class FlikrData(
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<Item>
)