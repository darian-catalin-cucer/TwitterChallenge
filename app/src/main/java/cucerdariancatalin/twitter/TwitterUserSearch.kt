package cucerdariancatalin.twitter

import android.app.Application
import cucerdariancatalin.twitter.koin.networkModule
import cucerdariancatalin.twitter.koin.repositoryModule
import cucerdariancatalin.twitter.koin.viewModelsModule
import cucerdariancatalin.twitter.core.networking.VolleyManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TwitterUserSearch: Application() {

    override fun onCreate() {
        super.onCreate()

        VolleyManager.initialise(this)

        startKoin {
            androidContext(this@TwitterUserSearch)
            modules(listOf(viewModelsModule, repositoryModule, networkModule))
        }
    }
}