package com.example.animalcrossing.ui.insect.dependencies

import com.example.animalcrossing.ui.detail.DetailViewModel
import com.example.animalcrossing.ui.insect.InsectRepository
import com.example.animalcrossing.ui.insect.InsectRepositoryImpl
import com.example.animalcrossing.ui.insect.InsectListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    single<InsectRepository> { InsectRepositoryImpl() }

    // Insect ViewModel
    viewModel { InsectListViewModel(get()) }

    //InsectDetail ViewModel
    viewModel { DetailViewModel() }
}
