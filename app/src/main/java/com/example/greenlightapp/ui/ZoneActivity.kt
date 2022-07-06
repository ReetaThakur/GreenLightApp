package com.example.greenlightapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.greenlightapp.R
import com.example.greenlightapp.database.CountryRoomdatabase
import com.example.greenlightapp.database.ItemDao
import com.example.greenlightapp.repository.Repository
import com.example.greenlightapp.viewModel.CountryViewModel
import kotlinx.android.synthetic.main.activity_zone.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZoneActivity : AppCompatActivity() {

    lateinit var  viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zone)
       viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            viewModel.callApi()
        }

        viewModel.mutableLiveData.observe(this) {
            when(it){
                is MainUiModel.Success ->{
                    tvCountry.text="${it.responseDTO.ResponseData.sales_country[0].country} Performance"
                    tvShowZone.text=it.responseDTO.ResponseData.sales_zone[0].zone

                }
                is MainUiModel.Failure ->{
                    Toast.makeText(this@ZoneActivity,"Error",Toast.LENGTH_LONG).show()
                }
            }
        }

        tvShowZone.setOnClickListener {
            val intent=Intent(this,RegionActivity::class.java)
            intent.putExtra("zoneName",tvShowZone.text)
            startActivity(intent)
        }

        allowImage.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}