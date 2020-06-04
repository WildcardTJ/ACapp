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
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_insect_detail.*
import kotlinx.android.synthetic.main.seasonality_recycler_item.*
import kotlinx.android.synthetic.main.toolbar_back.*


class InsectDetailFragment : Fragment() {

    private lateinit var adapter: SeasonalityAdapter

    private lateinit var insectModel: InsectModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_insect_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        insectModel = this.requireArguments().get("InsectModel") as InsectModel
        
        requireActivity().title = insectModel.name
        showPrice(insectModel.value)
        showDonationStatus(insectModel.donated)
        setupSeasonalityView(insectModel.seasonality)
        setupActiveHoursView(insectModel.activeHours)
        donated_card.setOnClickListener { updateDonation() }
    }

    private fun updateDonation() {
        insectModel.donated = !insectModel.donated
        showDonationStatus(insectModel.donated)
    }

    private fun showPrice(value: Int) {

        if (value == 0)
            insect_value.text = getString(R.string.price_data_unavailable)
        else
            insect_value.text = value.toString()
    }

    private fun showDonationStatus(donated: Boolean) {

        if (donated) {
            not_donated_image.visibility = View.INVISIBLE
            donated_image.visibility = View.VISIBLE
            insect_donated.text = getString(R.string.donated)
        } else {
            not_donated_image.visibility = View.VISIBLE
            donated_image.visibility = View.INVISIBLE
            insect_donated.text = getString(R.string.not_donated)
        }
    }

    private fun setupSeasonalityView(seasonality: List<String>) {
        val seasonalityMap = convertListToMap(seasonality)
        adapter = SeasonalityAdapter(seasonalityMap)
        seasonality_recycler_view.adapter = adapter
        val numberOfColumns = 6
        seasonality_recycler_view.layoutManager = GridLayoutManager(context, numberOfColumns)
    }

    private fun setupActiveHoursView(activeHours: String) {

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

}