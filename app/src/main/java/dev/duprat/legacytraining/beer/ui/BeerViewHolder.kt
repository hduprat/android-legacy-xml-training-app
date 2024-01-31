package dev.duprat.legacytraining.beer.ui

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import dev.duprat.legacytraining.beer.model.Beer

class BeerViewHolder(private val beerCard: BeerCard): ViewHolder(beerCard) {
    fun bind(beer: Beer) {
        beerCard.setBeer(beer)
    }
}