package com.landomen.kaminoplanet.data.source.local.planet.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Entity(tableName = DatabaseConstants.TABLE_NAME_PLANETS_LIKED)
data class PlanetLikeCached(@PrimaryKey
                            val planetId: Int,
                            val liked: Boolean)