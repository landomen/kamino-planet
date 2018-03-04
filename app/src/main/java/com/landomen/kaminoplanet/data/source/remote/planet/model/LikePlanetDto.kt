package com.landomen.kaminoplanet.data.source.remote.planet.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
data class LikePlanetDto(@SerializedName("planet_id")
                         val planetId: Int,
                         @SerializedName("likes")
                         val likes: Int)