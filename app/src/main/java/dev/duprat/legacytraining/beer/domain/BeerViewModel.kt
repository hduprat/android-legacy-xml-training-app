package dev.duprat.legacytraining.beer.domain

import androidx.lifecycle.ViewModel

class BeerViewModel(repository: BeerRepository): ViewModel() {
    val state = repository.getBeers()
}