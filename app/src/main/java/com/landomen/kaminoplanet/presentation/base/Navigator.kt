package com.landomen.kaminoplanet.presentation.base

import android.content.Context
import com.landomen.kaminoplanet.presentation.imagepreview.ImagePreviewActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class Navigator @Inject constructor() {

    fun openImagePreview(context: Context, imageUrl: String?) {
        context.startActivity<ImagePreviewActivity>(ImagePreviewActivity.EXTRA_IMAGE_URL to imageUrl)
    }
}