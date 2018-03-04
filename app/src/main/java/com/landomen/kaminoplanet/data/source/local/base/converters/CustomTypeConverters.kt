package com.landomen.kaminoplanet.data.source.local.base.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class CustomTypeConverters {

    @TypeConverter
    fun fromList(list: List<Int>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromString(value: String): List<Int> {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }

}