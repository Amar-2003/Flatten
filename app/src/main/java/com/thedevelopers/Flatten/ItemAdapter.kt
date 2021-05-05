package com.thedevelopers.Flatten

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val context: DetailFragment, val items:ArrayList<HashMap<String, String>>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_item_row_details,parent,false))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item=items.get(position)
        val MobileNumber = item["Mobile"]
        holder.name.text=item["Name"]
        holder.mobile.text= MobileNumber
        holder.address.text=item["Address"]
        holder.help.text=item["Help"]
        holder.requestCloseButton.setOnClickListener (object : View.OnClickListener{
            override fun onClick(view: View?) {

            }
        })
        holder.callButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                val intent = Intent(Intent.ACTION_DIAL);
                intent.data = Uri.parse("tel: $MobileNumber");
                if (view != null) {
                    startActivity(view.context, Intent.createChooser(intent,"Dial"), Bundle.EMPTY)
                }
            }
        })
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
        val requestCloseButton = view.findViewById<ImageButton>(R.id.closeButton)
        val callButton: ImageButton = view.findViewById(R.id.callButton)
    }
}