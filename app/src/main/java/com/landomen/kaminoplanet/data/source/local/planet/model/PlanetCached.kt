package com.landomen.kaminoplanet.data.source.local.planet.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Entity(tableName = DatabaseConstants.TABLE_NAME_PLANETS)
data class PlanetCached(
        @PrimaryKey
        val id: Int,
        val name: String?,
        val rotationPeriod: Double?,
        val orbitalPeriod: Double?,
        val diameter: Double?,
        val climate: String?,
        val gravity: String?,
        val terrain: String?,
        val surfaceWater: Double?,
        val population: Long?,
        val residents: List<Int>,
        val created: String?,
        val edited: String?,
        val imageUrl: String?,
        val likesCount: Int
)