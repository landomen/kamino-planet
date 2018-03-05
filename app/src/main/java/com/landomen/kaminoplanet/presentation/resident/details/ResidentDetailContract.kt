package com.landomen.kaminoplanet.presentation.resident.details

import com.landomen.kaminoplanet.presentation.base.mvp.BasePresenter
import com.landomen.kaminoplanet.presentation.base.mvp.BaseView
import com.landomen.kaminoplanet.presentation.common.model.TitleValue

/**
 * Created by Domen Lanišnik on 05/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ResidentDetailContract {

    interface View : BaseView {
        fun setToolbarTitle(title: String)
        fun displayResidentName(name: String)
        fun displayResidentImage(imageUrl: String)
        fun displayResidentDetails(details: List<TitleValue>)
        fun displayImageLoadingError()
        fun displayError()
        fun openImagePreview(imageUrl: String?)
    }

    interface Presenter : BasePresenter<View> {
        fun initialize(residentId: Int)
        fun onImageLoadingFailed()
        fun onImageClicked()
        fun onRetryClicked()
    }
}