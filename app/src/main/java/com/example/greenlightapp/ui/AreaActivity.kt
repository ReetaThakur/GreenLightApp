package com.example.greenlightapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greenlightapp.R
import com.example.greenlightapp.adapter.AreaAdapter
import com.example.greenlightapp.databinding.ActivityAreaBinding
import kotlinx.android.synthetic.main.activity_area.*

class AreaActivity : AppCompatActivity() {
    var listOfAreas = ArrayList<String>()
    lateinit var areaAdapter: AreaAdapter
    lateinit var areaBinding:ActivityAreaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        areaBinding=DataBindingUtil.setContentView(this,R.layout.activity_area)
        areaBinding.areaPerformance.text="${intent.getStringExtra("region")} Performance"
        listOfAreas= intent.getStringArrayListExtra("listOfArea")!!
        setRecyclerView()
        areaBinding.areabackArrowImage.setOnClickListener {
            val intent= Intent(this,RegionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setRecyclerView() {
       areaAdapter= AreaAdapter(listOfAreas)
        val linearLayoutManager=LinearLayoutManager(this)
        recyclerViewArea.apply {
            adapter=areaAdapter
            layoutManager=linearLayoutManager
        }
    }
}