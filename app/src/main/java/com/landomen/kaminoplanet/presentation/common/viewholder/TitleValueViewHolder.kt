package com.landomen.kaminoplanet.presentation.common.viewholder

import android.view.View
import com.landomen.kaminoplanet.presentation.base.viewholder.BaseViewHolder
import com.landomen.kaminoplanet.presentation.common.model.TitleValue
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_item_detail.*

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class TitleValueViewHolder(override val containerView: View) :
        BaseViewHolder<TitleValue>(containerView), LayoutContainer {

    override fun bind(model: TitleValue, position: Int) {
        titleTextView.text = containerView.resources.getString(model.title.stringResId)
        valueTextView.text = model.value
    }

}