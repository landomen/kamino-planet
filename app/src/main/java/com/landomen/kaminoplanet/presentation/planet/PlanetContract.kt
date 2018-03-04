package com.landomen.kaminoplanet.presentation.planet

import com.landomen.kaminoplanet.presentation.base.mvp.BasePresenter
import com.landomen.kaminoplanet.presentation.base.mvp.BaseView
import com.landomen.kaminoplanet.presentation.common.model.TitleValue

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface PlanetContract {

    interface View : BaseView {
        fun displayError()
        fun displayPlanetName(name: String)
        fun displayPlanetLikesCount(count: Int)
        fun displayPlanetImage(imageUrl: String)
        fun displayPlanetDetails(details: List<TitleValue>)

        fun toggleViewResidentsButton(visible: Boolean)
        fun togglePlanetLikeButton(visible: Boolean)
        fun displayLikeSuccess()
        fun displayLikeError()

        fun openImagePreview(imageUrl: String?)
        fun openResidentsActivity(residents: List<Int>)
    }

    interface Presenter : BasePresenter<View> {
        fun initialize(planetId: Int)
        fun onImageClicked()
        fun onPlanetLikeClicked()
        fun onViewResidentsClicked()
    }

}