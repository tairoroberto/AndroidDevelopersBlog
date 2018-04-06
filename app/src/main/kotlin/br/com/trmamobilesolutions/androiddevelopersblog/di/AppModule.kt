package br.com.trmamobilesolutions.androiddevelopersblog.di

import android.content.Context
import br.com.trmamobilesolutions.androiddevelopersblog.data.AppDatabase
import br.com.trmamobilesolutions.androiddevelopersblog.data.dao.PostsDao
import br.com.trmamobilesolutions.androiddevelopersblog.CustomApplication
import br.com.trmamobilesolutions.androiddevelopersblog.data.home.HomeLocalDataStore
import br.com.trmamobilesolutions.androiddevelopersblog.data.home.HomeRemoteDataStore
import br.com.trmamobilesolutions.androiddevelopersblog.domain.home.HomeLocalRepository
import br.com.trmamobilesolutions.androiddevelopersblog.domain.home.HomeRemoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
class AppModule {

    @Provides
    internal fun provideContext(application: CustomApplication): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    internal fun provideJobsDao(context: Context): PostsDao {
        return AppDatabase.getInstance(context).jobsDAO()
    }

    @Singleton
    @Provides
    internal fun provideHomeLocalRepository(postsDao: PostsDao): HomeLocalRepository {
        return HomeLocalDataStore(postsDao)
    }

    @Singleton
    @Provides
    internal fun provideHomeRemoteRepository(): HomeRemoteRepository {
        return HomeRemoteDataStore()
    }
}
