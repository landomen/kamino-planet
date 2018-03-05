package com.landomen.kaminoplanet.presentation.base.mvp

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface BaseView {

    fun showDataLoading()

    fun hideDataLoading()

    fun showError()
}