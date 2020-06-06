package com.example.animalcrossing.ui.insect.model

import java.io.Serializable


data class InsectModel (
    val id: Int,
    val name: String,
    var donated: Boolean,
    val calendar: List<String>,
    val activeHours: String, //4am 8am 4pm 5pm 7pm 11pm All Day
    val value: Int,
    val rarity: Float //TODO in app displayed as % or string (common, uncommon, rare, very rare)
) : Serializable