package com.example.animalcrossing.ui.insect.model

import java.io.Serializable


data class InsectModel (
    val id: Int,
    val name: String,
    var donated: Boolean,
    val seasonality: List<String>, //TODO northern and southern hemisphere
    val activeHours: String,
    val value: Int,
    val rarity: Float //TODO in app displayed as % or string (common, uncommon, rare, very rare)
) : Serializable