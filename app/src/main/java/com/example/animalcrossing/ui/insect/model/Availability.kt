package com.example.animalcrossing.ui.insect.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Availability (
    @SerializedName("month-northern") val calendarNorthern: String,
    @SerializedName("month-southern") val calendarSouthern: String,
    @SerializedName("time") val time: String,
    @SerializedName("isAllDay") val isAllDay: Boolean,
    @SerializedName("isAllYear") val isAllYear: Boolean,
    @SerializedName("location") val location: String,
    @SerializedName("rarity") val rarity: String
) : Serializable
