package dev.duprat.legacytraining.beer.domain

import dev.duprat.legacytraining.beer.api.BeerApiService
import dev.duprat.legacytraining.beer.model.BeerAdapter

class BeerRepository(private val api: BeerApiService) {
    suspend fun getBeers() = api.getBeers().map(BeerAdapter::toDomain)
}