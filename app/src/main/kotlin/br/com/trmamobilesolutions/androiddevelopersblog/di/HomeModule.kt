package com.remoteok.io.app.di

import br.com.trmamobilesolutions.androiddevelopersblog.domain.home.HomeLocalRepository
import br.com.trmamobilesolutions.androiddevelopersblog.domain.home.HomeRemoteRepository
import br.com.trmamobilesolutions.androiddevelopersblog.domain.home.HomeUseCase
import br.com.trmamobilesolutions.androiddevelopersblog.viewmodel.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Define HomeFragment-specific dependencies here.
 */
@Module
class HomeModule {

    @Provides
    internal fun provideHomeViewModelFactory(homeUseCase: HomeUseCase): HomeViewModelFactory {
        return HomeViewModelFactory(homeUseCase)
    }

    @Provides
    internal fun provideHomeUseCase(homeLocalRepository: HomeLocalRepository,
                                    remoteRepository: HomeRemoteRepository): HomeUseCase {
        return HomeUseCase(homeLocalRepository, remoteRepository)
    }
}
