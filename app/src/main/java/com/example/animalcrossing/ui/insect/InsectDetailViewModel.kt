package com.example.animalcrossing.ui.insect

import androidx.lifecycle.ViewModel
import com.example.animalcrossing.ui.insect.model.AccountModel
import com.example.animalcrossing.ui.insect.model.Hemisphere
import com.example.animalcrossing.ui.insect.model.InsectModel


class InsectDetailViewModel : ViewModel() {

    var accountModel: AccountModel = AccountModel(Hemisphere.NORTHERN)
    var insect: InsectModel? = null

    fun updateAccountModelHemisphere() {

        if (accountModel.hemisphere == Hemisphere.NORTHERN)
            accountModel.hemisphere = Hemisphere.SOUTHERN
        else
            accountModel.hemisphere = Hemisphere.NORTHERN
    }

    fun convertListToMap(activeMonthsList: List<String>): HashMap<String, Boolean> {

        val allMonths = listOf(
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sept",
            "Oct",
            "Nov",
            "Dec"
        )

        //TODO refactor because it is stupid

        //create a map, set all values to false
        val activeMonthsMap = mutableMapOf<String, Boolean>()
        allMonths.forEach { month -> activeMonthsMap[month] = false }

        //matches only active months, sets those to true
        activeMonthsList.forEach { month ->
            if (activeMonthsMap[month] == false) {
                activeMonthsMap[month] = true
            }
        }

        return activeMonthsMap as HashMap
    }
}