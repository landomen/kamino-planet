package com.landomen.kaminoplanet.presentation.resident.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.presentation.resident.list.viewholder.ResidentViewHolder
import com.landomen.kaminoplanet.presentation.common.extensions.inflate
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentsRecyclerAdapter @Inject constructor() : RecyclerView.Adapter<ResidentViewHolder>() {

    var listener: ((resident: ResidentEntity) -> Unit)? = null
    var items: List<ResidentEntity> by Delegates.observable(listOf()) { _, old, new ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentViewHolder {
        return ResidentViewHolder(parent.inflate(R.layout.recycler_item_resident))
    }

    override fun onBindViewHolder(holder: ResidentViewHolder, position: Int) {
        val resident = items[position]
        holder.bind(resident, position)
        holder.itemView.setOnClickListener {
            listener?.invoke(resident)
        }
    }

    override fun getItemCount(): Int = items.size
}
