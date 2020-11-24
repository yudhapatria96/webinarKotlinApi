package com.example.indonesiacoronawebinar.model


import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("FID") var fID: Int,
    @SerializedName("Kasus_Meni") var kasusMeni: Int,
    @SerializedName("Kasus_Posi") var kasusPosi: Int,
    @SerializedName("Kasus_Semb") var kasusSemb: Int,
    @SerializedName("Kode_Provi") var kodeProvi: Int,
    @SerializedName("Provinsi") var provinsi: String
)