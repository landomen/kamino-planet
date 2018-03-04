package com.landomen.kaminoplanet.data.source.local

import android.arch.persistence.room.Room
import android.content.Context
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants
import com.landomen.kaminoplanet.data.source.local.base.db.StarWarsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
class LocalModule {

    @Provides
    @Singleton
    internal fun provideStarWarsDatabase(context: Context): StarWarsDatabase {
        return Room.databaseBuilder(context.applicationContext,
                StarWarsDatabase::class.java, DatabaseConstants.DATABASE_FILENAME)
                .build()
    }

}