package com.example.indonesiacoronawebinar.service



import com.example.indonesiacoronawebinar.model.KasusCoronaIndonesia
import com.example.indonesiacoronawebinar.model.KasusCoronaProvinsi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("indonesia")
    fun getDataCovidIndonesia(): Call<KasusCoronaIndonesia>

    @GET("indonesia/provinsi/")
    fun getDataCovidProvinsi(): Call<KasusCoronaProvinsi>


}