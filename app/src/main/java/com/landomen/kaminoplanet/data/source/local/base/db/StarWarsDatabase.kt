package com.landomen.kaminoplanet.data.source.local.base.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants
import com.landomen.kaminoplanet.data.source.local.base.converters.CustomTypeConverters
import com.landomen.kaminoplanet.data.source.local.planet.dao.PlanetDao
import com.landomen.kaminoplanet.data.source.local.planet.model.PlanetCached
import com.landomen.kaminoplanet.data.source.local.planet.model.PlanetLikeCached
import com.landomen.kaminoplanet.data.source.local.resident.dao.ResidentDao
import com.landomen.kaminoplanet.data.source.local.resident.model.ResidentCached

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Database(entities = [PlanetCached::class, ResidentCached::class, PlanetLikeCached::class],
        version = DatabaseConstants.DATABASE_VERSION,
        exportSchema = true)
@TypeConverters(CustomTypeConverters::class)
abstract class StarWarsDatabase : RoomDatabase() {

    abstract fun planetDao(): PlanetDao
    abstract fun residentDao(): ResidentDao

}