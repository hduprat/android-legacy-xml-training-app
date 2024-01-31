package dev.duprat.legacytraining.beer.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.duprat.legacytraining.beer.model.Beer

class BeerAdapter(private val beers: List<Beer>) : RecyclerView.Adapter<BeerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder =
        BeerViewHolder(BeerCard(parent.context))

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.setBackgroundByPosition(position)
        holder.bind(beers[position])
    }

    override fun getItemCount(): Int = beers.size
}