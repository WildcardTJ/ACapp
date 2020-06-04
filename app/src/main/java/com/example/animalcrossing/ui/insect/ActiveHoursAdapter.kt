package com.example.animalcrossing.ui.insect

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.animalcrossing.R
import kotlinx.android.synthetic.main.seasonality_recycler_item.view.*

class ActiveHoursAdapter(
    private val activeHours: String
) : RecyclerView.Adapter<ActiveHoursAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.seasonality_recycler_item, parent, false).run {
                ViewHolder(this)
            }
    }

    override fun getItemCount(): Int = activeHours.length

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        activeHours.values.toList()[position].run {
//            holder.updateBoxColour(this)
//            holder.updateText(activeHours.keys.toList()[position])
//            holder.updateTextColor(this)
        }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal fun updateBoxColour(enabled: Boolean) {
            if (enabled) {
                itemView.month_layout.setBackgroundColor(itemView.resources.getColor(R.color.monthEnabled))
                //TODO selectable themes
            }
        }

        internal fun updateText(name: String) {
            itemView.month_text.text = name
        }

        internal fun updateTextColor(enabled: Boolean) {
            if (enabled) {
                itemView.month_text.setTextColor(Color.WHITE)
            }
        }
    }
}