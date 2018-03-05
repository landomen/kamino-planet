package com.landomen.kaminoplanet.presentation.imagepreview

import com.landomen.kaminoplanet.presentation.base.mvp.BasePresenter
import com.landomen.kaminoplanet.presentation.base.mvp.BaseView

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ImagePreviewContract {

    interface View : BaseView {
        fun displayImage(imageUrl: String)
    }

    interface Presenter : BasePresenter<View> {
        fun initialize(imageUrl: String?)
        fun onImageLoaded()
        fun onImageLoadingFailed()
    }
}