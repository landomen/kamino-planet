package com.landomen.kaminoplanet.data.source.remote.model.planet

import com.google.gson.annotations.SerializedName

/**
 * Created by Domen Lanišnik on 03/03/2018.
 * domen.lanisnik@gmail.com
 */
data class PlanetDto(@SerializedName("name")
                     val name: String?,
                     @SerializedName("rotation_period")
                     val rotationPeriod: Double?,
                     @SerializedName("orbital_period")
                     val orbitalPeriod: Double?,
                     @SerializedName("diameter")
                     val diameter: Double?,
                     @SerializedName("climate")
                     val climate: String?,
                     @SerializedName("gravity")
                     val gravity: String?,
                     @SerializedName("terrain")
                     val terrain: String?,
                     @SerializedName("surface_water")
                     val surfaceWater: Double?,
                     @SerializedName("population")
                     val population: Long?,
                     @SerializedName("residents")
                     val residents: List<String>,
                     @SerializedName("created")
                     val created: String?,
                     @SerializedName("edited")
                     val edited: String?,
                     @SerializedName("image_url")
                     val imageUrl: String?,
                     @SerializedName("likes")
                     val likesCount: Int = 0)
