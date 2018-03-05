package com.landomen.kaminoplanet.presentation.resident.details.module

import com.landomen.kaminoplanet.di.scopes.PerActivity
import com.landomen.kaminoplanet.presentation.resident.details.ResidentDetailContract
import com.landomen.kaminoplanet.presentation.resident.details.ResidentDetailPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by Domen Lanišnik on 05/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
abstract class ResidentDetailActivityModule {

    @PerActivity
    @Binds
    abstract fun bindResidentDetailPresenter(planetPresenter: ResidentDetailPresenter): ResidentDetailContract.Presenter

}