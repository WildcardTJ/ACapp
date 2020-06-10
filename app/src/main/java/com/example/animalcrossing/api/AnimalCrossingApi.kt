package com.example.animalcrossing.api

import com.example.animalcrossing.ui.insect.model.InsectRequestModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimalCrossingApi {

    @GET("/v1/bugs/{id}")
    fun getInsect(@Path("id") id: Int?): Call<InsectRequestModel>

}
