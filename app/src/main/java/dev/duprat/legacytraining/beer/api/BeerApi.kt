package dev.duprat.legacytraining.beer.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.punkapi.com/v2/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val beerApi: BeerApiService = retrofit.create(BeerApiService::class.java)