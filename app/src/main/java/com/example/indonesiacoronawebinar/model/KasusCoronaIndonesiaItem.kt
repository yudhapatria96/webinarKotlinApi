package com.example.indonesiacoronawebinar.model


import com.google.gson.annotations.SerializedName

data class KasusCoronaIndonesiaItem(
    @SerializedName("dirawat") var dirawat: String,
    @SerializedName("meninggal") var meninggal: String,
    @SerializedName("name") var name: String,
    @SerializedName("positif") var positif: String,
    @SerializedName("sembuh") var sembuh: String
)