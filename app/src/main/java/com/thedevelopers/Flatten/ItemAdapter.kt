package com.thedevelopers.Flatten

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val context: DetailFragment, val items:ArrayList<String>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_item_row_details,parent,false))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item=items.get(position)
        holder.name.text=item
        holder.mobile.text=item
        holder.address.text=item
        holder.help.text=item
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val name: TextView=view.findViewById(R.id.name_item)
        val mobile:TextView=view.findViewById(R.id.mobile_item)
        val address:TextView=view.findViewById(R.id.address_item)
        val help:TextView=view.findViewById(R.id.help_item)
        val cardViewItem: CardView =view.findViewById(R.id.card_view_item)

    }
}