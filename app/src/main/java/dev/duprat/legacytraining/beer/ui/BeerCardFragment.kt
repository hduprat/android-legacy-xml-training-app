package dev.duprat.legacytraining.beer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dev.duprat.legacytraining.beer.model.Beer
import dev.duprat.legacytraining.databinding.BeerCardBinding

class BeerCardFragment : Fragment() {
    private var name: String? = null
    private var tagline: String? = null
    private var imageUrl: String? = null
    private var hops: List<String> = emptyList()
    private var malts: List<String> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("name")
            tagline = it.getString("tagline")
            hops = it.getStringArray("hops")?.toList() ?: emptyList()
            malts = it.getStringArray("malts")?.toList() ?: emptyList()
            imageUrl = it.getString("imageUrl")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = BeerCardBinding.inflate(inflater, container, false)
        binding.apply {
            beerName.text = name
            beerTagline.text = tagline
            beerHopsTagList.addTags(hops)
            beerMaltsTagList.addTags(malts)
            beerImage.apply {
                contentDescription = name
                Glide.with(this).load(imageUrl).into(this)
            }
        }

        return binding.root
    }

    companion object {
        fun newInstance(model: Beer) = BeerCardFragment().apply {
            arguments = bundleOf(
                "name" to model.name,
                "tagline" to model.tagline,
                "hops" to model.hops.toTypedArray(),
                "malts" to model.malts.toTypedArray(),
                "imageUrl" to model.imageUrl
            )
        }
    }
}