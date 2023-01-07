package cucerdariancatalin.twitter.koin

import cucerdariancatalin.twitter.core.networking.API
import cucerdariancatalin.twitter.core.networking.VolleyManager
import cucerdariancatalin.twitter.core.repository.Repository
import cucerdariancatalin.twitter.core.repository.RepositoryImpl
import cucerdariancatalin.twitter.screens.details.UserDetailsViewModel
import cucerdariancatalin.twitter.screens.search.UserSearchViewModel
import org.koin.dsl.module

val viewModelsModule = module{
    single { UserSearchViewModel(get()) }
    single { UserDetailsViewModel(get()) }
}

val repositoryModule = module {
    single { RepositoryImpl(get()) as Repository }
}

val networkModule = module {
    single { VolleyManager as API }
}