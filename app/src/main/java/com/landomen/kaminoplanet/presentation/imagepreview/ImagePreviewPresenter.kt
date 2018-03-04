package com.landomen.kaminoplanet.presentation.imagepreview

import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ImagePreviewPresenter @Inject constructor() : ImagePreviewContract.Presenter {

    private var view: ImagePreviewContract.View? = null

    override fun initialize(imageUrl: String?) {
        if (imageUrl != null) {
            view?.displayImage(imageUrl)
        } else {
            view?.displayImageLoadingError()
        }
    }

    override fun takeView(view: ImagePreviewContract.View) {
        this.view = view
    }

    override fun destroy() {
        this.view = null
    }

    override fun onImageLoadingFailed() {
        view?.displayImageLoadingError()
    }


}