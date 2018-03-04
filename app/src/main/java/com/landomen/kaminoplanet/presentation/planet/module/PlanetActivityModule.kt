package com.landomen.kaminoplanet.presentation.planet.module

import com.landomen.kaminoplanet.di.scopes.PerActivity
import com.landomen.kaminoplanet.presentation.planet.PlanetContract
import com.landomen.kaminoplanet.presentation.planet.PlanetPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
abstract class PlanetActivityModule {

    @PerActivity
    @Binds
    abstract fun bindPlanetPresenter(planetPresenter: PlanetPresenter): PlanetContract.Presenter
}