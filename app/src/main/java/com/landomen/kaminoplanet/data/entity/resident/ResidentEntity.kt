package com.landomen.kaminoplanet.data.entity.resident

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
data class ResidentEntity(val id: Int,
                          val name: String?,
                          val height: Double?,
                          val mass: String?,
                          val hairColor: String?,
                          val skinColor: String?,
                          val eyeColor: String?,
                          val birthYear: String?,
                          val gender: String?,
                          val homeworld: String?,
                          val created: String?,
                          val edited: String?,
                          val imageUrl: String?,
                          var planetId: Int = 0)