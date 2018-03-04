package com.landomen.kaminoplanet.di.module

import com.landomen.kaminoplanet.di.scopes.PerActivity
import com.landomen.kaminoplanet.presentation.imagepreview.ImagePreviewActivity
import com.landomen.kaminoplanet.presentation.imagepreview.module.ImagePreviewActivityModule
import com.landomen.kaminoplanet.presentation.planet.PlanetActivity
import com.landomen.kaminoplanet.presentation.planet.module.PlanetActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [PlanetActivityModule::class])
    abstract fun planetActivity(): PlanetActivity


    @PerActivity
    @ContributesAndroidInjector(modules = [ImagePreviewActivityModule::class])
    abstract fun iamgePreviewActivity(): ImagePreviewActivity
}