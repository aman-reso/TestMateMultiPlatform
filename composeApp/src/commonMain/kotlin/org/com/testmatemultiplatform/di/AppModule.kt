package org.com.testmatemultiplatform.di

import org.com.testmatemultiplatform.auth.AuthRepository
import org.com.testmatemultiplatform.auth.LoginViewModel
import org.com.testmatemultiplatform.localstorage.PostViewModel
import org.com.testmatemultiplatform.network.provideHttpClient
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { provideHttpClient() }
    single { provideHttpClient() }
    single { AuthRepository(get()) }
    viewModel { LoginViewModel(get()) }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}