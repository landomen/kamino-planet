package com.landomen.kaminoplanet.data.source.local.resident.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants
import com.landomen.kaminoplanet.data.source.local.resident.model.ResidentCached
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Dao
interface ResidentDao {

    @Query("SELECT * FROM ${DatabaseConstants.TABLE_NAME_RESIDENTS} WHERE planetId = :planetId")
    fun getResidents(planetId: Int): Flowable<List<ResidentCached>>

    @Query("SELECT * FROM ${DatabaseConstants.TABLE_NAME_RESIDENTS} WHERE id = :residentId")
    fun getResidentById(residentId: Int): Maybe<ResidentCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResident(resident: ResidentCached)

}