package com.landomen.kaminoplanet.presentation.imagepreview.module

import com.landomen.kaminoplanet.di.scopes.PerActivity
import com.landomen.kaminoplanet.presentation.imagepreview.ImagePreviewContract
import com.landomen.kaminoplanet.presentation.imagepreview.ImagePreviewPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
abstract class ImagePreviewActivityModule {

    @PerActivity
    @Binds
    abstract fun bindImagePreviewPresenter(planetPresenter: ImagePreviewPresenter): ImagePreviewContract.Presenter
}