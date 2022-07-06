package com.example.greenlightapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greenlightapp.R
import com.example.greenlightapp.adapter.RegionAdapter
import com.example.greenlightapp.database.ItemTable
import com.example.greenlightapp.databinding.ActivityRegsionBinding
import com.example.greenlightapp.response.ResponseData
import com.example.greenlightapp.response.SalesRegion
import com.example.greenlightapp.viewModel.CountryViewModel
import kotlinx.android.synthetic.main.activity_regsion.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegionActivity : AppCompatActivity(), RegionInterface {

    lateinit var regionAdapter: RegionAdapter
    lateinit var binding : ActivityRegsionBinding
    var listOfItems= ArrayList<ItemTable>()
    var listOfAreas=ArrayList<String>()
    lateinit var responseData: ResponseData

   lateinit var  viewModel: CountryViewModel

  //  val viewModel: CountryViewModel by viewModels()
    var regionList=ArrayList<SalesRegion>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_regsion)
        zonePerformance.text="${intent.getStringExtra("zoneName")} Performance"

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
      //   viewModel.deleteItem()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.callApi()
        }
        viewModel.mutableLiveData.observe(this) {

            when(it){
                is MainUiModel.Success ->{
                   regionList=it.responseDTO.ResponseData.sales_region as ArrayList<SalesRegion>
                   responseData=it.responseDTO.ResponseData
                    setRecyclerView()
                }

                is MainUiModel.Failure ->{
                    Toast.makeText(this@RegionActivity,"Error", Toast.LENGTH_LONG).show()
                }
            }
        }

        regionList.forEach {
            listOfItems.add(ItemTable(it.region))
        }
     //   viewModel.insertItem(listOfItems)



        binding.backArrowImage.setOnClickListener {
            val intent= Intent(this,ZoneActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setRecyclerView(){
        regionAdapter= RegionAdapter(regionList,this,responseData)
        val linearLayoutManager= LinearLayoutManager(this)
        recyclerView.apply {
            adapter=regionAdapter
            layoutManager=linearLayoutManager
        }
    }

    override fun clickItem(region: String,responseData: ResponseData) {
        listOfAreas.clear()
        Log.v("reeta",region)
        val area=region.uppercase()
         responseData.sales_area.forEach {
             if (it.territory.contains(area)) {
                 listOfAreas.add(it.area)
             }
         }
        Log.v("reeta","${listOfAreas.size}")
        val intent=Intent(this,AreaActivity::class.java)
        intent.putExtra("listOfArea",listOfAreas)
        intent.putExtra("region",region)
        startActivity(intent)
    }
}