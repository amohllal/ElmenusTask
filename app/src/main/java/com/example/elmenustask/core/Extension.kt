package com.example.elmenustask.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.showImage(url: String?) {
    Glide.with(context)
        .load(url)
        .circleCrop()
        .into(this)
}

fun Context.openYoutubeVideo(youtubeUrl: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
    intent.setPackage("com.google.android.youtube")
    startActivity(intent)
}