package com.example.greenlightapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.greenlightapp.R
import com.example.greenlightapp.response.ResponseData
import com.example.greenlightapp.response.SalesRegion
import com.example.greenlightapp.ui.RegionInterface

class RegionAdapter(val dataList:ArrayList<SalesRegion>, val clickListner: RegionInterface,
                    val responseData: ResponseData): RecyclerView.Adapter<RegionAdapter.ZoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZoneViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
         return ZoneViewHolder(view,clickListner)
    }

    override fun onBindViewHolder(holder: ZoneViewHolder, position: Int) {
        val oneData=dataList[position]
        holder.setData(oneData,responseData)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ZoneViewHolder(itemView:View,val clickListner: RegionInterface):RecyclerView.ViewHolder(itemView){
      val zone:TextView=itemView.findViewById(R.id.tvtZone)
        fun setData(oneData:SalesRegion,responseData: ResponseData){
            var setZone =oneData.region
            zone.text=setZone
            zone.setOnClickListener {
                clickListner.clickItem(setZone,responseData)
            }
        }
    }
}