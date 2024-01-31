package dev.duprat.legacytraining.beer.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import dev.duprat.legacytraining.beer.model.Beer
import dev.duprat.legacytraining.databinding.BeerCardBinding

class BeerCard(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    private val binding = BeerCardBinding.inflate(LayoutInflater.from(context), this, true)

    fun setBeer(beer: Beer) {
        binding.apply {
            beerName.text = beer.name
            beerTagline.text = beer.tagline
            beerHopsTagList.setTags(beer.hops)
            beerMaltsTagList.setTags(beer.malts)
            beerImage.apply {
                contentDescription = beer.name
                Glide.with(this).load(beer.imageUrl).into(this)
            }
        }
    }

}