package com.example.animalcrossing.ui.insect

import androidx.lifecycle.ViewModel
import com.example.animalcrossing.ui.insect.model.AccountModel
import com.example.animalcrossing.ui.insect.model.Hemisphere
import com.example.animalcrossing.ui.insect.model.InsectModel


class InsectDetailViewModel : ViewModel() {

    var accountModel: AccountModel = AccountModel(Hemisphere.NORTHERN)
    var insect: InsectModel? = null
}