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

    val insectData: List<InsectModel> = InsectOfflineData().getInsectOfflineData()

}