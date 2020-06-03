package com.example.animalcrossing.ui.insect

import android.app.Activity
import android.content.Intent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.home.HomeFragment
import com.example.animalcrossing.ui.insect.model.InsectModel
import kotlinx.android.synthetic.main.insect_recylcer_item.view.*


class InsectAdapter(
    private val insectList: List<InsectModel>
) : RecyclerView.Adapter<InsectAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.insect_recylcer_item, parent, false).run {
                ViewHolder(this)
            }
    }

    override fun getItemCount(): Int = insectList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = insectList[position].run {
        setClickListeners(holder, position, this)
        holder.updateInsectName(this.name)
        holder.updateDonatedState(this.donated)
    }

    private fun setClickListeners(
        holder: ViewHolder,
        position: Int,
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
            val navController = findNavController(HomeFragment())
            val parentActivity: Activity = itemView.context as Activity

            val intent = Intent(itemView.context, InsectDetailActivity::class.java)
            intent.putExtra("insect", insectModel)
            parentActivity.startActivity(intent)
        }
    }
}