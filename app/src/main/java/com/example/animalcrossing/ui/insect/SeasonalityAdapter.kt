package com.example.animalcrossing.ui.insect

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.Hemisphere
import kotlinx.android.synthetic.main.calendar_item.view.*

class SeasonalityAdapter(
    private val seasonality: Map<String, Boolean>,
    private val hemisphere: Hemisphere
) : RecyclerView.Adapter<SeasonalityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_item, parent, false).run {
                ViewHolder(this)
            }
    }

    override fun getItemCount(): Int = seasonality.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        seasonality.values.toList()[position].run {
            val enabled: Boolean = if (hemisphere == Hemisphere.SOUTHERN) !this else this
            holder.updateBoxColour(enabled)
            holder.updateText(seasonality.keys.toList()[position])
            holder.updateTextColor(enabled)
            //TODO highlight current month
        }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal fun updateBoxColour(enabled: Boolean) {

            //TODO selectable themes
            if (enabled)
                itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.activeMonth))
            else
                itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.inactiveMonth))
        }

        internal fun updateText(name: String) { itemView.month_text.text = name }

        internal fun updateTextColor(enabled: Boolean) {

            if (enabled)
                itemView.month_text.setTextColor(Color.WHITE)
            else
                itemView.month_text.setTextColor(Color.GRAY)
        }
    }
}