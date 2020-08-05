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
import kotlinx.android.synthetic.main.insect_list_item.*

class InsectListFragment : Fragment() {

    private val listViewModel: InsectListViewModel by viewModel()

    private lateinit var listAdapter: InsectListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_insect_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val insectData = listViewModel.insectData
        setupRecyclerView(insectData)
        showInsects(insectData)
        updateInsectImage(insectData)
        //TODO show number of donated
    }

    private fun updateInsectImage(insectData: List<InsectModel>) {
        insectData.forEach {
            it.src
        }
    }

    private fun setupRecyclerView(insectData: List<InsectModel>) {

        val recyclerView = view?.findViewById<RecyclerView>(R.id.insect_recycler_view)
        val numberOfColumns = 3
        recyclerView?.layoutManager = GridLayoutManager(this.context, numberOfColumns)
        listAdapter = InsectListAdapter(insectData)
        recyclerView?.adapter = listAdapter
    }

    private fun showInsects(insects: List<InsectModel>) = insect_text.run {

        listAdapter = InsectListAdapter(insects)
    }
}
