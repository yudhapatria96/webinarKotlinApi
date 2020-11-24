package com.example.indonesiacoronawebinar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.indonesiacoronawebinar.model.KasusCoronaIndonesia
import com.example.indonesiacoronawebinar.model.KasusCoronaProvinsi
import com.example.indonesiacoronawebinar.service.ApiNetwork
import com.example.indonesiacoronawebinar.service.ApiService
import retrofit2.Call
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var apiService : ApiService
    private lateinit var provinsiAdapter: ProvinsiAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = ApiNetwork.connectApi()

        apiService.getDataCovidIndonesia().enqueue(object : retrofit2.Callback<KasusCoronaIndonesia>{
            override fun onFailure(call: Call<KasusCoronaIndonesia>, t: Throwable) {
                Log.d("cekerror", t.message.toString())
            }

            override fun onResponse(
                    call: Call<KasusCoronaIndonesia>,
                    response: Response<KasusCoronaIndonesia>
            ) {

                tvKasus.text = response.body()?.get(0)?.positif
                tvSembuh.text = response.body()?.get(0)?.sembuh
                tvMeninggal.text = response.body()?.get(0)?.meninggal
            }

        })

        apiService.getDataCovidProvinsi().enqueue(object : retrofit2.Callback<KasusCoronaProvinsi>{
            override fun onFailure(call: Call<KasusCoronaProvinsi>, t: Throwable) {
                Log.d("cekerrorprovinsi", t.message.toString())
            }

            override fun onResponse(
                    call: Call<KasusCoronaProvinsi>,
                    response: Response<KasusCoronaProvinsi>
            ) {
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

                provinsiAdapter = ProvinsiAdapter(response.body())
                rvProvinsi.adapter =provinsiAdapter
                rvProvinsi.layoutManager = layoutManager
            }

        })

    }




}