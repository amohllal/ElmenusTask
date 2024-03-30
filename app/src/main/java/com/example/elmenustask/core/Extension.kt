package com.example.elmenustask.core

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.showImage(url: String?) {
    Glide.with(context)
        .load(url)
        .circleCrop()
        .into(this)
}