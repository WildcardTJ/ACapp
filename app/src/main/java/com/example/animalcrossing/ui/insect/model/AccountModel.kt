package com.example.animalcrossing.ui.insect.model

import java.io.Serializable

enum class Hemisphere {
    NORTHERN,
    SOUTHERN
}

enum class Language {
    EU_EN,
    EU_DE,
    EU_ES,
    EU_FR,
    EU_IT,
    EU_NL,
    EU_RU,
    US_EN,
    US_ES,
    US_FR,
    CN_ZH,
    TW_ZH,
    JP_JA,
    KR_KO
}


data class AccountModel(
    var hemisphere: Hemisphere = Hemisphere.NORTHERN,
    var language: Language = Language.EU_EN
): Serializable