package com.example.animalcrossing.ui.insect

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.InsectModel
import kotlinx.android.synthetic.main.activity_insect_detail.*
import kotlinx.android.synthetic.main.activity_insect_detail.donated_image
import kotlinx.android.synthetic.main.seasonality_recycler_item.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class InsectDetailActivity : AppCompatActivity() {

    private lateinit var adapter: SeasonalityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoin()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insect_detail)
        val insectModel: InsectModel = intent.extras?.get("insect") as InsectModel

        val map: HashMap<String, Boolean> = convertListToMap(insectModel.seasonality)
        setupRecyclerView(map)
        showYears(map)

        insect_value.text = insectModel.toString()
        this.title = insectModel.name
        insect_value.text = insectModel.value.toString()
        if (insectModel.value == 0) {
            insect_value.text = getString(R.string.price_data_unavailable)
        }
        insect_donated.text = getString(R.string.not_donated)

        if (insectModel.donated) {
            not_donated_image.visibility = View.GONE
            donated_image.visibility = View.VISIBLE
            insect_donated.text = getString(R.string.donated)
        }
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@InsectDetailActivity)
            modules(appModule)
        }
    }

    private fun setupRecyclerView(map: HashMap<String, Boolean>) {
        val recyclerView = findViewById<RecyclerView>(R.id.seasonality_recycler_view)
        val numberOfColumns = 6
        recyclerView?.layoutManager = GridLayoutManager(this, numberOfColumns)
        adapter = SeasonalityAdapter(map)
        recyclerView?.adapter = adapter
    }

    private fun convertListToMap(months: List<String>): HashMap<String, Boolean> {
        val monthList = listOf(
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
        val monthMap = mutableMapOf<String, Boolean>()
        monthList.forEach { month -> monthMap[month] = false }
        months.forEach { month ->
            if (monthMap[month] == false) {
                monthMap[month] = true
            }
        }
        return monthMap as HashMap
    }

    private fun showYears(map: HashMap<String, Boolean>) = month_layout.run {
        adapter = SeasonalityAdapter(map)
    }
}