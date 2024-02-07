package dev.duprat.legacytraining.beer.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import org.mobilenativefoundation.store.store5.StoreReadResponse
import org.mobilenativefoundation.store.store5.StoreReadResponseOrigin

class BeerViewModel(repository: BeerRepository) : ViewModel() {
    val state = repository.getBeers()
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            StoreReadResponse.Loading(StoreReadResponseOrigin.Fetcher())
        )
}