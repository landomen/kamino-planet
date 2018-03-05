package com.landomen.kaminoplanet.presentation.resident.list

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.presentation.base.mvp.BasePresenter
import com.landomen.kaminoplanet.presentation.base.mvp.BaseView

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ResidentListContract {

    interface View : BaseView {
        fun displayResidents(residents: List<ResidentEntity>)
        fun displayError()
        fun openResidentDetailsActivity(residentId: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun initialize(planetId: Int)
        fun onRetryClicked()
        fun onResidentClicked(resident: ResidentEntity)
    }
}