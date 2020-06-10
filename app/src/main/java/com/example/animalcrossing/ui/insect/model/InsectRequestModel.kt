package com.example.animalcrossing.ui.insect.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class InsectRequestModel (
    @SerializedName("id") val id: Int,
    @SerializedName("file-name") val filename: String,
    @SerializedName("availability") val availability: Availability,
    @SerializedName("price") val price: Int,
    var donated: Boolean,
    var src: String
) : Serializable