package com.example.animalcrossing.ui.detail

import android.content.Context
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
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.donated_image


class InsectDetailFragment : Fragment() {

    private lateinit var adapter: CalendarAdapter

    private val viewModel: DetailViewModel by viewModel()

    private lateinit var insect: InsectModel
    private lateinit var accountModel: AccountModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        viewModel.insect = this.requireArguments().get("InsectModel") as InsectModel
        insect = viewModel.insect!!
        accountModel = viewModel.accountModel

        //TODO have detail image drawn as percentage of screen

        showImage(insect.src)
        showPrice(insect.value)
        showDonationStatus(insect.donated)
        setupCalendarView(insect.calendar)
        setupActiveHoursView(insect.activeHours)
        donated_card.setOnClickListener { updateDonation() }
        northern_southern.setOnClickListener { updateHemisphere() }
    }

    private fun showImage(src: String) {

        val imageId = requireContext().resources.getIdentifier(src, "drawable", requireContext().packageName)
        if (imageId != 0)
            detail_image.setImageResource(imageId)
        else
            detail_image.setImageResource(R.drawable.ic_insect_foreground)
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

    private fun setupCalendarView(calendar: List<String>) {
        //transition when north/south switch occurs
        val calendarMap = viewModel.convertMonthListToMap(calendar)
        adapter = CalendarAdapter(
            calendarMap,
            accountModel.hemisphere
        )
        calendar_grid.adapter = adapter
        calendar_grid.layoutManager =
            NonScrollableGridLayoutManager(
                context,
                NUMBER_OF_COLUMNS
            )
        //TODO refactor calendar view to use TableLayout instead of RecyclerView
    }

    private fun setupActiveHoursView(activeHours: String) {

    }

    companion object {

        private const val NUMBER_OF_COLUMNS = 6
    }

    internal class NonScrollableGridLayoutManager(context: Context?, columns: Int) : GridLayoutManager(context, columns) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }

}