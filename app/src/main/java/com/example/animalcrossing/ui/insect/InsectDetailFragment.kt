package com.example.animalcrossing.ui.insect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.AccountModel
import com.example.animalcrossing.ui.insect.model.InsectModel
import kotlinx.android.synthetic.main.fragment_insect_detail.*


class InsectDetailFragment : Fragment() {

    private lateinit var adapter: SeasonalityAdapter

    private val viewModel: InsectDetailViewModel by viewModel()

    private lateinit var insect: InsectModel
    private lateinit var accountModel: AccountModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_insect_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        viewModel.insect = this.requireArguments().get("InsectModel") as InsectModel
        insect = viewModel.insect!!
        accountModel = viewModel.accountModel

        showPrice(insect.value)
        showDonationStatus(insect.donated)
        setupSeasonalityView(insect.seasonality)
        setupActiveHoursView(insect.activeHours)
        donated_card.setOnClickListener { updateDonation() }
        northern_southern.setOnClickListener { updateHemisphere() }
    }

    private fun updateDonation() {

        insect.donated = !insect.donated
        showDonationStatus(insect.donated)
    }

    private fun updateHemisphere() {

        viewModel.updateAccountModelHemisphere()

        adapter.notifyDataSetChanged()
    }

    private fun showPrice(value: Int) {

        if (value == 0)
            price_text.text = getString(R.string.price_data_unavailable)
        else
            price_text.text = value.toString()
    }

    private fun showDonationStatus(donated: Boolean) {

        if (donated) {
            donated_image.visibility = View.VISIBLE
            donated_text.visibility = View.VISIBLE
            not_donated_image.visibility = View.INVISIBLE
            not_donated_text.visibility = View.INVISIBLE
        } else {
            not_donated_image.visibility = View.VISIBLE
            not_donated_text.visibility = View.VISIBLE
            donated_image.visibility = View.INVISIBLE
            donated_text.visibility = View.INVISIBLE
        }
    }

    private fun setupSeasonalityView(seasonality: List<String>) {
        //transition when north/south switch occurs
        val seasonalityMap = viewModel.convertListToMap(seasonality)
        adapter = SeasonalityAdapter(seasonalityMap, accountModel.hemisphere)
        calendar_grid.adapter = adapter
        calendar_grid.layoutManager = GridLayoutManager(context, NUMBER_OF_COLUMNS)
    }

    private fun setupActiveHoursView(activeHours: String) {

    }

    companion object {

        private const val NUMBER_OF_COLUMNS = 6
    }

}