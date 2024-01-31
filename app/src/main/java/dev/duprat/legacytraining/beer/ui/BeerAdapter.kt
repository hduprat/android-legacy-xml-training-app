package dev.duprat.legacytraining.beer.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.duprat.legacytraining.beer.model.Beer

class BeerAdapter(private val beers: List<Beer>) : RecyclerView.Adapter<BeerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val beerCard = BeerCard(parent.context).apply {
            layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
        }

        return BeerViewHolder(beerCard)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.setBackgroundByPosition(position)
        holder.bind(beers[position])
    }

    override fun getItemCount(): Int = beers.size
}