package kaa.nurlibaydev.locationtrackingapp.di.koin

import kaa.nurlibaydev.locationtrackingapp.presentation.LocationViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {
    // viewModelOf(::LocationViewModel)
    viewModel { LocationViewModel(get()) }
}
