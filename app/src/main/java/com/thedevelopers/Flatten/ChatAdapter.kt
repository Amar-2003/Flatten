package com.thedevelopers.Flatten

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.thedevelopers.Flatten.MyApplication.Companion.globaluid

class ChatAdapter(val context: ChatFragment, val items:ArrayList<HashMap<String,String>>): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_item_row_chat,parent,false))
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        val item=items.get(position)
        holder.message.text=item["message"]
        holder.sender.text = item["sender"]

        holder.timestamp.text = item["time"].toString()


    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val message:TextView=view.findViewById(R.id.message)
        val sender:TextView = view.findViewById(R.id.chat_sender)
        val timestamp: TextView = view.findViewById(R.id.timestamp_chat)
        val cardView: CardView = view.findViewById(R.id.message_card_view)
    }
}