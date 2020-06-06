package com.example.animalcrossing.ui.insect

import androidx.lifecycle.ViewModel
import com.example.animalcrossing.ui.insect.model.AccountModel
import com.example.animalcrossing.ui.insect.model.Hemisphere
import com.example.animalcrossing.ui.insect.model.InsectModel
import com.example.animalcrossing.utils.DataUtils


class InsectDetailViewModel : ViewModel() {

    var accountModel: AccountModel = AccountModel(Hemisphere.NORTHERN)
    var insect: InsectModel? = null

    fun updateAccountModelHemisphere() {

        if (accountModel.hemisphere == Hemisphere.NORTHERN)
            accountModel.hemisphere = Hemisphere.SOUTHERN
        else
            accountModel.hemisphere = Hemisphere.NORTHERN
    }

    fun convertMonthListToMap(activeMonthsList: List<String>): HashMap<String, Boolean> = DataUtils().convertMonthListToMap(activeMonthsList)

}