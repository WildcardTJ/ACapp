package com.example.animalcrossing.ui.insect.model

import java.io.Serializable

enum class Hemisphere {
    NORTHERN,
    SOUTHERN
}

data class AccountModel(
    var hemisphere: Hemisphere = Hemisphere.NORTHERN
): Serializable