package com.landomen.kaminoplanet.presentation.base

import android.content.Context
import com.landomen.kaminoplanet.presentation.imagepreview.ImagePreviewActivity
import com.landomen.kaminoplanet.presentation.resident.list.ResidentListActivity
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class Navigator @Inject constructor() {

    fun openImagePreview(context: Context, imageUrl: String?) {
        context.startActivity(ImagePreviewActivity.createIntent(context, imageUrl))
    }

    fun openResidentsList(context: Context, planetId: Int) {
        context.startActivity(ResidentListActivity.createIntent(context, planetId))
    }
}