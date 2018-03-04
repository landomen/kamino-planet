package com.landomen.kaminoplanet.data.repository.planet.source

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import io.reactivex.Flowable

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface PlanetLocalSource {

    fun getPlanet(id: Int): Flowable<PlanetEntity>

    fun savePlanet(planet: PlanetEntity)

}