package com.example.animalcrossing.ui.insect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.Hemisphere
import com.example.animalcrossing.ui.insect.model.Hemisphere.*
import com.example.animalcrossing.ui.insect.model.InsectModel
import kotlinx.android.synthetic.main.fragment_insect_detail.*


class InsectDetailFragment : Fragment() {

    private lateinit var adapter: SeasonalityAdapter

    private val viewModel: InsectDetailViewModel by viewModel()

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
        northern_southern.setOnClickListener { updateHemisphere() }
    }

    private fun updateDonation() {
        insectModel.donated = !insectModel.donated
        showDonationStatus(insectModel.donated)
    }

    private fun updateHemisphere() {

//        if (viewModel.accountModel.hemisphere == NORTHERN)
//            viewModel.accountModel.hemisphere = SOUTHERN
//        else
//            viewModel.accountModel.hemisphere = NORTHERN
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
        val seasonalityMap = convertListToMap(seasonality, SOUTHERN)
        adapter = SeasonalityAdapter(seasonalityMap)
        seasonality_recycler_view.adapter = adapter
        val numberOfColumns = 6
        seasonality_recycler_view.layoutManager = GridLayoutManager(context, numberOfColumns)
    }

    private fun setupActiveHoursView(activeHours: String) {

    }

    private fun convertListToMap(
        activeMonthsList: List<String>,
        hemisphere: Hemisphere
    ): HashMap<String, Boolean> {

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

        if (hemisphere == SOUTHERN)
            activeMonthsMap.forEach { (month, active) -> activeMonthsMap[month] = !active }

        return activeMonthsMap as HashMap
    }

}