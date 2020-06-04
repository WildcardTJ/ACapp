package com.example.animalcrossing.ui.insect

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    single<InsectRepository> { InsectRepositoryImpl() }

    // Insect ViewModel
    viewModel { InsectViewModel(get()) }

    //InsectDetail ViewModel
    viewModel { InsectDetailViewModel() }
}
