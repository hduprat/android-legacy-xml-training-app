package dev.duprat.legacytraining.beer.domain

import dev.duprat.legacytraining.beer.api.BeerApiService
import dev.duprat.legacytraining.beer.model.BeerAdapter
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.StoreBuilder
import org.mobilenativefoundation.store.store5.StoreReadRequest

class BeerRepository(private val api: BeerApiService) {
    private val store = StoreBuilder.from(
        fetcher = Fetcher.of { api.getBeers().map(BeerAdapter::toDomain) },
    ).build()

    fun getBeers() = store.stream(StoreReadRequest.cached("", refresh = false))
}