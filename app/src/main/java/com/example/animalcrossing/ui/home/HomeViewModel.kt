package com.example.animalcrossing.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalcrossing.api.AnimalCrossingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import kotlin.coroutines.coroutineContext

class HomeViewModel (private val service: AnimalCrossingService) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun requestInsectData() {

        viewModelScope.launch(Dispatchers.IO) {
            val model = service.getInsect(1)
            println("##### here")
            println(model.awaitResponse().body())
        }
    }

}