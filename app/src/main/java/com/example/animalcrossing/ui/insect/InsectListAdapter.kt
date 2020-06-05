package com.example.animalcrossing.ui.insect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.InsectModel
import kotlinx.android.synthetic.main.insect_list_item.view.*


class InsectListAdapter(
    private val insectList: List<InsectModel>
) : RecyclerView.Adapter<InsectListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.insect_list_item, parent, false).run {
                ViewHolder(this)
            }
    }

    override fun getItemCount(): Int = insectList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = insectList[position].run {
        setClickListeners(holder, this)
        holder.updateInsectName(this.name)
        holder.updateDonatedState(this.donated)
    }

    private fun setClickListeners(
        holder: ViewHolder,
        insectModel: InsectModel
    ) {
        val insectText = holder.itemView.findViewById<TextView>(R.id.insect_text)
        val insectImage = holder.itemView.findViewById<ImageButton>(R.id.insect_image)
        insectText.setOnClickListener { holder.openInsectPage(insectModel) }
        insectImage.setOnClickListener { holder.openInsectPage(insectModel) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal fun updateInsectName(name: String) {
            itemView.insect_text.text = name
        }

        internal fun updateDonatedState(donated: Boolean) {
            if (donated) { itemView.donated_image.visibility = View.VISIBLE }
            else { itemView.donated_image.visibility = View.GONE }
        }

        internal fun openInsectPage(insectModel: InsectModel) {

            val bundle = Bundle()
            bundle.putSerializable("InsectModel", insectModel)
            bundle.putString("title", insectModel.name)
            itemView.findNavController().navigate(R.id.action_nav_insect_to_insect_detail, bundle)
        }
    }
}