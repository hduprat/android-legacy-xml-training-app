package dev.duprat.legacytraining.beer.domain

import dev.duprat.legacytraining.beer.api.beerApi
import org.koin.dsl.module

val beerModule = module {
    single { BeerRepository(beerApi) }
}