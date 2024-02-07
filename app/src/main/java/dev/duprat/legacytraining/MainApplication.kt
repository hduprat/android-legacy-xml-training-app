package dev.duprat.legacytraining

import android.app.Application
import dev.duprat.legacytraining.beer.domain.beerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(beerModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}