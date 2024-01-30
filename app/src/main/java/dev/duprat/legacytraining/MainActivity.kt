package dev.duprat.legacytraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.duprat.legacytraining.beer.domain.beerModule
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            modules(beerModule)
        }
        setContentView(R.layout.activity_main)
    }
}