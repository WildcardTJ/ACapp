package com.example.animalcrossing.ui.insect.dependencies

import com.example.animalcrossing.BuildConfig
import com.example.animalcrossing.api.AnimalCrossingApi
import com.example.animalcrossing.api.AnimalCrossingService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
    }

    single { get<Retrofit>().create(AnimalCrossingApi::class.java)}

    single { AnimalCrossingService(get())}
}
