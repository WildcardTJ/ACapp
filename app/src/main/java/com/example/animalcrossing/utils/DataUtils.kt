package com.example.animalcrossing.utils

import android.view.View
import android.widget.ImageButton
import com.example.animalcrossing.R

class DataUtils {

    fun convertMonthListToMap(activeMonthsList: List<String>): HashMap<String, Boolean> {

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