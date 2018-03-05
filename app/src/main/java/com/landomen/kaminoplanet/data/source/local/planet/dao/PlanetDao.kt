package com.landomen.kaminoplanet.data.source.local.planet.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants
import com.landomen.kaminoplanet.data.source.local.planet.model.PlanetCached
import com.landomen.kaminoplanet.data.source.local.planet.model.PlanetLikeCached
import io.reactivex.Single

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Dao
interface PlanetDao {

    @Query("SELECT * FROM ${DatabaseConstants.TABLE_NAME_PLANETS} WHERE id = :planetId")
    fun getPlanetById(planetId: Int): Single<PlanetCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlanet(planet: PlanetCached)

    @Query("SELECT * FROM ${DatabaseConstants.TABLE_NAME_PLANETS_LIKED} WHERE planetId = :planetId")
    fun getPlanetLike(planetId: Int): PlanetLikeCached?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlanetLike(planetLikeCached: PlanetLikeCached)

}