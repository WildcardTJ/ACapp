package com.example.animalcrossing.ui.insect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.InsectModel
import kotlinx.android.synthetic.main.fragment_insect_detail.*
import kotlinx.android.synthetic.main.seasonality_recycler_item.*


class InsectDetailFragment : Fragment() {

    private lateinit var adapter: SeasonalityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_insect_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val insectModel = this.requireArguments().get("InsectModel") as InsectModel

        insect_value.text = insectModel.toString()
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

        setupSeasonalityView(insectModel.seasonality)

    }

    private fun setupSeasonalityView(seasonality: List<String>) {
        val seasonalityMap = convertListToMap(seasonality)
        val recyclerView: RecyclerView = seasonality_recycler_view
        val numberOfColumns = 6
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColumns)
        adapter = SeasonalityAdapter(seasonalityMap)
        recyclerView.adapter = adapter
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