package com.landomen.kaminoplanet.presentation.common.extensions

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener

fun RequestBuilder<Drawable>.listener(onSuccess: () -> Unit = {}, onFailure: () -> Unit = {}): RequestBuilder<Drawable> {
    return listener(object : RequestListener<Drawable> {

        override fun onResourceReady(resource: Drawable?,
                                     model: Any?,
                                     target: com.bumptech.glide.request.target.Target<Drawable>?,
                                     dataSource: DataSource?,
                                     isFirstResource: Boolean): Boolean {
            onSuccess()
            return false
        }

        override fun onLoadFailed(e: GlideException?,
                                  model: Any?,
                                  target: com.bumptech.glide.request.target.Target<Drawable>?,
                                  isFirstResource: Boolean): Boolean {
            onFailure()
            return false
        }

    })
}