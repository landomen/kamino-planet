package com.landomen.kaminoplanet.presentation.base.mvp

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface BasePresenter<in V : BaseView> {

    /**
     * Sets the view reference.
     *
     * @param view
     */
    fun takeView(view: V)

    /**
     * Perform any final cleanup, the view is going to be destroyed.
     */
    fun destroy()

    fun onRetry()
}