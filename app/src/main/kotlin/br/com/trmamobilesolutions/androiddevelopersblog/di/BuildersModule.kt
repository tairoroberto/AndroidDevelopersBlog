package br.com.trmamobilesolutions.androiddevelopersblog.di

import com.remoteok.io.app.di.HomeModule
import com.remoteok.io.app.view.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Binds all sub-components within the app.
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    internal abstract fun bindHomeFragment(): HomeFragment

    // Add bindings for other sub-components here
}
