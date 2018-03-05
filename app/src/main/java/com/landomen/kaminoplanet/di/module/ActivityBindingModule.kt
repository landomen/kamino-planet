package com.landomen.kaminoplanet.di.module

import com.landomen.kaminoplanet.di.scopes.PerActivity
import com.landomen.kaminoplanet.presentation.imagepreview.ImagePreviewActivity
import com.landomen.kaminoplanet.presentation.imagepreview.module.ImagePreviewActivityModule
import com.landomen.kaminoplanet.presentation.planet.PlanetActivity
import com.landomen.kaminoplanet.presentation.planet.module.PlanetActivityModule
import com.landomen.kaminoplanet.presentation.resident.list.ResidentListActivity
import com.landomen.kaminoplanet.presentation.resident.list.module.ResidentListActivityModule
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
    abstract fun imagePreviewActivity(): ImagePreviewActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [ResidentListActivityModule::class])
    abstract fun residentListActivity(): ResidentListActivity
}