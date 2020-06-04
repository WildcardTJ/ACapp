package com.example.animalcrossing.ui.insect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.animalcrossing.R
import com.example.animalcrossing.ui.insect.model.InsectModel
import kotlinx.android.synthetic.main.insect_recylcer_item.*

class InsectFragment : Fragment() {

    private val insectViewModel: InsectViewModel by viewModel()

    private lateinit var adapter: InsectAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_insect, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val insectData = insectViewModel.getInsectData()
        setupRecyclerView(insectData)
        showInsects(insectData)
    }

    private fun setupRecyclerView(insectData: List<InsectModel>) {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.insect_recycler_view)
        val numberOfColumns = 3
        recyclerView?.layoutManager = GridLayoutManager(this.context, numberOfColumns)
        adapter = InsectAdapter(insectData)
        recyclerView?.adapter = adapter

    }

    private fun showInsects(insects: List<InsectModel>) = insect_text.run {

        adapter = InsectAdapter(insects)
    }
}