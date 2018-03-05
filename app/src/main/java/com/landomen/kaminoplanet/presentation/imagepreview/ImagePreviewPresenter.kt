package com.landomen.kaminoplanet.presentation.imagepreview

import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ImagePreviewPresenter @Inject constructor() : ImagePreviewContract.Presenter {

    private var view: ImagePreviewContract.View? = null
    private var imageUrl: String? = null

    override fun initialize(imageUrl: String?) {
        this.imageUrl = imageUrl
        loadImage(imageUrl)
    }

    override fun takeView(view: ImagePreviewContract.View) {
        this.view = view
    }

    override fun destroy() {
        this.view = null
    }

    override fun onRetry() {
        loadImage(imageUrl)
    }

    override fun onImageLoaded() {
        view?.hideDataLoading()
    }

    override fun onImageLoadingFailed() {
        view?.showError()
    }

    private fun loadImage(imageUrl: String?) {
        view?.showDataLoading()
        if (imageUrl != null) {
            view?.displayImage(imageUrl)
        } else {
            view?.showError()
        }
    }

}