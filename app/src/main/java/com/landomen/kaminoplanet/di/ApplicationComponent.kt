package com.landomen.kaminoplanet.di

import android.app.Application
import com.landomen.kaminoplanet.KaminoApp
import com.landomen.kaminoplanet.data.source.local.LocalModule
import com.landomen.kaminoplanet.data.source.remote.NetModule
import com.landomen.kaminoplanet.di.module.ApplicationModule
import com.landomen.kaminoplanet.di.module.PlanetRepositoryModule
import com.landomen.kaminoplanet.di.module.ResidentRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Domen Lanišnik on 03/03/2018.
 * domen.lanisnik@gmail.com
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    NetModule::class,
    LocalModule::class,
    PlanetRepositoryModule::class,
    ResidentRepositoryModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: KaminoApp)

}