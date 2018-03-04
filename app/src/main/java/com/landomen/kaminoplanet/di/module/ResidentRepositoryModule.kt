package com.landomen.kaminoplanet.di.module

import com.landomen.kaminoplanet.data.repository.resident.ResidentDataRepository
import com.landomen.kaminoplanet.data.repository.resident.ResidentRepository
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentLocalSource
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentRemoteSource
import com.landomen.kaminoplanet.data.source.local.resident.ResidentLocalDataSource
import com.landomen.kaminoplanet.data.source.remote.resident.ResidentRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
abstract class ResidentRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLocal(localDataSource: ResidentLocalDataSource): ResidentLocalSource

    @Singleton
    @Binds
    abstract fun bindRemote(remoteDataSource: ResidentRemoteDataSource): ResidentRemoteSource

    @Singleton
    @Binds
    abstract fun bindRepository(dataRepository: ResidentDataRepository): ResidentRepository
}