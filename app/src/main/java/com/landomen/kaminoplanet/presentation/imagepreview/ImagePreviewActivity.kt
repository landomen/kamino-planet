package com.landomen.kaminoplanet.presentation.imagepreview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.presentation.base.BaseActivity
import com.landomen.kaminoplanet.util.extensions.listener
import com.landomen.kaminoplanet.util.extensions.showSnackbar
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_image_preview.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ImagePreviewActivity : BaseActivity(), ImagePreviewContract.View {

    companion object {
        private const val EXTRA_IMAGE_URL = "ImageUrl"

        fun createIntent(context: Context, imageUrl: String?): Intent {
            return context.intentFor<ImagePreviewActivity>(EXTRA_IMAGE_URL to imageUrl)
        }
    }

    @Inject
    lateinit var presenter: ImagePreviewContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview)
        setupInjection()
        initializePresenter()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun setupToolbar() = Unit

    override fun setupListeners() = Unit

    override fun setupInjection() {
        AndroidInjection.inject(this)
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
                .listener(onFailure = {
                    presenter.onImageLoadingFailed()
                })
                .into(imageView)
    }

    override fun displayImageLoadingError() {
        imageView.showSnackbar(R.string.error_image_load)
    }
}