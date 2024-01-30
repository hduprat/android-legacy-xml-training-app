package dev.duprat.legacytraining.beer.api

import dev.duprat.legacytraining.beer.model.BeerDto
import retrofit2.http.GET


interface BeerApiService {
    @GET("beers")
    suspend fun getBeers(): List<BeerDto>
}