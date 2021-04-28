package com.thedevelopers.Flatten

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DetailFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_detail, container, false)
        val recyclerView:RecyclerView=root.findViewById(R.id.recyclerViewDetails)
        recyclerView.layoutManager=LinearLayoutManager(context)
        val itemAdapter=ItemAdapter(this,getItemsList())
        recyclerView.adapter=(itemAdapter)


        return root
    }
    private fun getItemsList(): ArrayList<String> {
        val list = ArrayList<String>()

        for(i in 1..15){
            list.add("Item $i")
        }

        return list
    }


}