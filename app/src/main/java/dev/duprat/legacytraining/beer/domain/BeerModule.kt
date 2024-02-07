package dev.duprat.legacytraining.beer.domain

import dev.duprat.legacytraining.beer.api.beerApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val beerModule = module {
    single { BeerRepository(beerApi) }
    viewModel { BeerViewModel(get()) }
}