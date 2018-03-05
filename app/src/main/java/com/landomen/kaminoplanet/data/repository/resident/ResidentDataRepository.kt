package com.landomen.kaminoplanet.data.repository.resident

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetLocalSource
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentLocalSource
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentRemoteSource
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentDataRepository @Inject constructor(private val remoteSource: ResidentRemoteSource,
                                                 private val localSource: ResidentLocalSource,
                                                 private val planetLocalSource: PlanetLocalSource) : ResidentRepository {

    override fun getResidents(planetId: Int): Single<List<ResidentEntity>> {
        return planetLocalSource.getPlanet(planetId)
                .map { it.residents.distinct() }
                .toFlowable()
                .flatMapIterable { it }
                .flatMap { residentId ->
                    remoteSource
                            .getResidentDetails(residentId)
                            .doOnSuccess {
                                localSource.saveResident(it.apply { this.planetId = planetId })
                            }
                            .onErrorResumeNext { localSource.getResident(residentId) }
                            .toFlowable()
                }
                .toList()

    }

    override fun getResident(residentId: Int): Single<ResidentEntity> {
        return localSource.getResident(residentId)
    }

}