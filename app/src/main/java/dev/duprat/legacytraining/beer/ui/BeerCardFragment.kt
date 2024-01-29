package dev.duprat.legacytraining.beer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dev.duprat.legacytraining.R
import dev.duprat.legacytraining.beer.model.Beer
import dev.duprat.legacytraining.common.ui.TagList

class BeerCardFragment : Fragment() {
    private var name: String? = null
    private var tagline: String? = null
    private var imageUrl: String? = null
    private var hops: List<String> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("name")
            tagline = it.getString("tagline")
            hops = it.getStringArray("hops")?.toList() ?: emptyList()
            imageUrl = it.getString("imageUrl")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.beer_card, container, false)

        return view.apply {
            findViewById<TextView>(R.id.beer_name).apply { text = name }
            findViewById<TextView>(R.id.beer_tagline).apply { text = tagline }
            findViewById<TagList>(R.id.beer_hops_tag_list).apply {
                addTags(hops)
            }
            findViewById<ImageView>(R.id.beer_image).apply {
                contentDescription = name
                Glide.with(this).load(imageUrl).into(this)
            }
        }
    }

    companion object {
        fun newInstance(model: Beer) = BeerCardFragment().apply {
            arguments = bundleOf(
                "name" to model.name,
                "tagline" to model.tagline,
                "hops" to model.hops.toTypedArray(),
                "imageUrl" to model.imageUrl
            )
        }
    }
}