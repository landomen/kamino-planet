package com.landomen.kaminoplanet.presentation.common.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.presentation.common.model.TitleValue
import com.landomen.kaminoplanet.presentation.common.viewholder.TitleValueViewHolder
import com.landomen.kaminoplanet.util.extensions.inflate
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class TitleValueRecyclerAdapter @Inject constructor() : RecyclerView.Adapter<TitleValueViewHolder>() {

    var items: List<TitleValue> by Delegates.observable(listOf()) { _, old, new ->
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                    old[oldItemPosition].title == new[newItemPosition].title

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                    old[oldItemPosition].value == new[newItemPosition].value

        })
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleValueViewHolder {
        return TitleValueViewHolder(parent.inflate(R.layout.recycler_item_detail))
    }

    override fun onBindViewHolder(holder: TitleValueViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
}