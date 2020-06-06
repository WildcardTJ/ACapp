package com.example.animalcrossing.ui.detail

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.Hemisphere
import kotlinx.android.synthetic.main.calendar_item.view.*

class CalendarAdapter(
    private val calendar: Map<String, Boolean>,
    private val hemisphere: Hemisphere
) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_item, parent, false).run {
                ViewHolder(
                    this
                )
            }
    }

    override fun getItemCount(): Int = calendar.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        calendar.values.toList()[position].run {
            val enabled: Boolean = if (hemisphere == Hemisphere.SOUTHERN) !this else this
            holder.setText(calendar.keys.toList()[position])
            holder.setColours(enabled, position)
            //TODO highlight current month, alternate background for month cells
        }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal fun setColours(enabled: Boolean, position: Int) {

            setBoxColours(position, enabled)
            setTextColors(enabled)
        }

        private fun setBoxColours(position: Int, enabled: Boolean) {

            //TODO selectable theme colours
            if (position < 6)
                setFirstRowBoxColours(position, enabled)
             else
                setSecondRowBoxColours(position, enabled)
        }

        private fun setFirstRowBoxColours(position: Int, enabled: Boolean) {

            if (enabled)
                itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.activeMonth))
            else {
                when (position % 2) {
                    1 -> itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.inactiveMonthAlternate))
                    else -> itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.inactiveMonth))
                }
            }
        }

        private fun setSecondRowBoxColours(position: Int, enabled: Boolean) {

            if (enabled)
                itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.activeMonth))
            else {
                when (position % 2) {
                    1 -> itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.inactiveMonth))
                    else -> itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.inactiveMonthAlternate))
                }
            }
        }

        private fun setTextColors(enabled: Boolean) {

            if (enabled)
                itemView.month_text.setTextColor(Color.WHITE)
            else
                itemView.month_text.setTextColor(Color.GRAY)
        }

        internal fun setText(name: String) { itemView.month_text.text = name }
    }
}