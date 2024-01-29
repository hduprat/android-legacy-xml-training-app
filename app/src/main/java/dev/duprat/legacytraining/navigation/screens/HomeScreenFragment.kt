package dev.duprat.legacytraining.navigation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.duprat.legacytraining.R
import dev.duprat.legacytraining.beer.model.Beer
import dev.duprat.legacytraining.beer.ui.BeerCardFragment

class HomeScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val beerCard = BeerCardFragment.newInstance(
            Beer(
                name = "Punk IPA",
                tagline = "Post Modern Classic. Spiky. Tropical. Hoppy.",
                hops = listOf("Ahtanum", "Chinook", "Simcoe"),
                imageUrl = "https://images.punkapi.com/v2/192.png",
                description = "Our scene-stealing flagship is an India Pale Ale that has become a byword for craft beer rebellion; synonymous with the insurgency against mass-produced, lowest common denominator beer. Punk IPA charges the barricades to fly its colours from the ramparts – full-on, full-flavour; at full-throttle."
            )
        )

        childFragmentManager.beginTransaction().replace(R.id.beer_card_fragment, beerCard).commit()
    }
}