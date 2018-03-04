package com.landomen.kaminoplanet.data.source.remote.resident.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Domen Lanišnik on 03/03/2018.
 * domen.lanisnik@gmail.com
 */
data class ResidentDto(@SerializedName("name")
                       val name: String?,
                       @SerializedName("height")
                       val height: Double?,
                       @SerializedName("mass")
                       val mass: Double?,
                       @SerializedName("hair_color")
                       val hairColor: String?,
                       @SerializedName("skin_color")
                       val skinColor: String?,
                       @SerializedName("eye_color")
                       val eyeColor: String?,
                       @SerializedName("birth_year")
                       val birthYear: String?,
                       @SerializedName("gender")
                       val gender: String?,
                       @SerializedName("homeworld")
                       val homeworld: String?,
                       @SerializedName("created")
                       val created: String?,
                       @SerializedName("edited")
                       val edited: String?,
                       @SerializedName("image_url")
                       val imageUrl: String?)