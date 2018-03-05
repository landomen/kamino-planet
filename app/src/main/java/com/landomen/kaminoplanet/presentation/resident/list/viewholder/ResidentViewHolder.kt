package com.landomen.kaminoplanet.presentation.resident.list.viewholder

import android.view.View
import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.presentation.base.viewholder.BaseViewHolder
import com.landomen.kaminoplanet.util.extensions.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_item_resident.*

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentViewHolder(override val containerView: View) :
        BaseViewHolder<ResidentEntity>(containerView), LayoutContainer {

    override fun bind(model: ResidentEntity, position: Int) {
        residentItemNameTextView.text = model.name
        model.imageUrl?.let {
            residentItemImageView.loadImage(it)
        }
    }
}