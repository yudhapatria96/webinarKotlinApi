package com.example.indonesiacoronawebinar.model


import com.google.gson.annotations.SerializedName

data class KasusCoronaProvinsiItem(
    @SerializedName("attributes") var attributes: Attributes
)