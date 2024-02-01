package dev.duprat.legacytraining.navigation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.duprat.legacytraining.beer.domain.BeerViewModel
import dev.duprat.legacytraining.beer.model.Beer
import dev.duprat.legacytraining.beer.ui.BeerAdapter
import dev.duprat.legacytraining.databinding.HomeScreenBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.mobilenativefoundation.store.store5.StoreReadResponse

class HomeScreenFragment : Fragment() {
    private lateinit var binding: HomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: BeerViewModel by viewModel()

        ViewCompat.setOnApplyWindowInsetsListener(binding.mainScreenTitle) { v, insets ->
            v.updatePadding(top = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top + v.paddingTop)

            WindowInsetsCompat.CONSUMED
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when (state) {
                        is StoreReadResponse.Data -> displayBeerList(state.value)
                        else -> Unit
                    }
                }
            }
        }
    }

    private fun displayBeerList(beers: List<Beer>) {
        val recyclerView = binding.beerCardList
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BeerAdapter(beers)
    }
}