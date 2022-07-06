package com.example.greenlightapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.greenlightapp.R

class AreaAdapter(val listOfAreas:ArrayList<String>):RecyclerView.Adapter<AreaAdapter.AreaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return AreaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
       val area=listOfAreas[position]
        holder.setData(area)
    }

    override fun getItemCount(): Int {
       return listOfAreas.size
    }

    class AreaViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val zone: TextView =itemView.findViewById(R.id.tvtZone)
        fun setData(area:String){
            zone.text=area
        }
    }
}