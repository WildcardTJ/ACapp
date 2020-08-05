package com.example.animalcrossing.api

import com.example.animalcrossing.ui.insect.model.InsectRequestModel
import retrofit2.Call

class AnimalCrossingService (private val api: AnimalCrossingApi) {

    fun getInsect(id: Int): Call<InsectRequestModel> = api.getInsect(id)
}
