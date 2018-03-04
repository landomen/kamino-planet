package com.landomen.kaminoplanet.data.source.local.planet.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants
import com.landomen.kaminoplanet.data.source.local.planet.model.PlanetCached
import io.reactivex.Flowable

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Dao
interface PlanetDao {

    @Query("SELECT * FROM ${DatabaseConstants.TABLE_NAME_PLANETS} WHERE id = :planetId")
    fun getPlanetById(planetId: Int): Flowable<PlanetCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlanet(planet: PlanetCached)

}