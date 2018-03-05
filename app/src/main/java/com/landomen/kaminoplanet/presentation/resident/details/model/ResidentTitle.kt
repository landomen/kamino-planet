package com.landomen.kaminoplanet.presentation.resident.details.model

import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.presentation.common.model.Title

/**
 * Created by Domen Lanišnik on 05/03/2018.
 * domen.lanisnik@gmail.com
 */
enum class ResidentTitle(private val resId: Int) : Title {
    RESIDENTS(R.string.residents),
    GENDER(R.string.resident_gender),
    MASS(R.string.resident_mass),
    HEIGHT(R.string.resident_height),
    BIRTH_YEAR(R.string.resident_birth_year),
    HAIR_COLOR(R.string.resident_hair_color),
    SKIN_COLOR(R.string.resident_skin_color),
    EYE_COLOR(R.string.resident_eye_color);

    override val stringResId: Int
        get() = resId
}