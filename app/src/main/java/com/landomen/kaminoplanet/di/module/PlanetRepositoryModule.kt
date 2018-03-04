package com.landomen.kaminoplanet.di.module

import com.landomen.kaminoplanet.data.repository.planet.PlanetDataRepository
import com.landomen.kaminoplanet.data.repository.planet.PlanetRepository
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetLocalSource
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetRemoteSource
import com.landomen.kaminoplanet.data.source.local.planet.PlanetLocalDataSource
import com.landomen.kaminoplanet.data.source.remote.planet.PlanetRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
abstract class PlanetRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLocal(localDataSource: PlanetLocalDataSource): PlanetLocalSource

    @Singleton
    @Binds
    abstract fun bindRemote(remoteDataSource: PlanetRemoteDataSource): PlanetRemoteSource

    @Singleton
    @Binds
    abstract fun bindRepository(dataRepository: PlanetDataRepository): PlanetRepository

}