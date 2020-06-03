package com.example.animalcrossing.ui.insect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animalcrossing.ui.insect.model.InsectModel

class InsectViewModel(private val repo: InsectRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is insect Fragment"
    }
    val text: LiveData<String> = _text

    private var insectData: List<InsectModel> = listOf()

    fun getInsectData(): List<InsectModel> {
        //TODO Api GET insect data
        //if get fails, load offline data
        insectData = InsectOfflineData().getInsectOfflineData()
        return insectData
    }
}