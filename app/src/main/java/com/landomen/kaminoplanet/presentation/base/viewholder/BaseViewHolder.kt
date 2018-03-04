package com.landomen.kaminoplanet.presentation.base.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in Model>(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(model: Model, position: Int)
}