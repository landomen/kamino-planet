package com.landomen.kaminoplanet.data.source.local.resident.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.landomen.kaminoplanet.data.source.local.base.constants.DatabaseConstants

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Entity(tableName = DatabaseConstants.TABLE_NAME_RESIDENTS)
data class ResidentCached(
        @PrimaryKey
        val id: Int,
        val name: String?,
        val height: Double?,
        val mass: Double?,
        val hairColor: String?,
        val skinColor: String?,
        val eyeColor: String?,
        val birthYear: String?,
        val gender: String?,
        val homeworld: String?,
        val created: String?,
        val edited: String?,
        val imageUrl: String?
)