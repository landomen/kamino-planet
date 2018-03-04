package com.landomen.kaminoplanet.presentation.imagepreview

import android.graphics.drawable.Drawable
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.presentation.base.BaseActivity
import com.landomen.kaminoplanet.util.extensions.showSnackbar
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_image_preview.*
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ImagePreviewActivity : BaseActivity(), ImagePreviewContract.View {

    companion object {
        const val EXTRA_IMAGE_URL = "ImageUrl"
    }

    @Inject
    lateinit var presenter: ImagePreviewContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview)
        AndroidInjection.inject(this)
        initializePresenter()
    }

    override fun initializePresenter() {
        presenter.takeView(this)
        presenter.initialize(intent?.getStringExtra(EXTRA_IMAGE_URL))
    }

    override fun showDataLoading() = Unit

    override fun hideDataLoading() = Unit

    override fun displayImage(imageUrl: String) {
        Glide.with(this)
                .load(imageUrl)
                .apply(RequestOptions()
                        .fitCenter()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher))
                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(e: GlideException?,
                                              model: Any?,
                                              target: Target<Drawable>?,
                                              isFirstResource: Boolean): Boolean {
                        presenter.onImageLoadingFailed()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?,
                                                 model: Any?,
                                                 target: Target<Drawable>?,
                                                 dataSource: DataSource?,
                                                 isFirstResource: Boolean): Boolean {
                        return false
                    }

                })
                .into(imageView)
    }

    override fun displayImageLoadingError() {
        imageView.showSnackbar(R.string.error_image_load)
    }
}