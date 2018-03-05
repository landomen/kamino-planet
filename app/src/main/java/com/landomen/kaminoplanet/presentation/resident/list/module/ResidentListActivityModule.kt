package com.landomen.kaminoplanet.presentation.resident.list.module

import com.landomen.kaminoplanet.di.scopes.PerActivity
import com.landomen.kaminoplanet.presentation.resident.list.ResidentListContract
import com.landomen.kaminoplanet.presentation.resident.list.ResidentListPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
abstract class ResidentListActivityModule {

    @PerActivity
    @Binds
    abstract fun bindResidentListPresenter(planetPresenter: ResidentListPresenter): ResidentListContract.Presenter
}