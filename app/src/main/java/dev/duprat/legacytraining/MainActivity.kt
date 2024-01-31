package dev.duprat.legacytraining

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.duprat.legacytraining.beer.domain.beerModule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        startKoin {
            modules(beerModule)
        }
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        stopKoin()
        super.onDestroy()
    }
}