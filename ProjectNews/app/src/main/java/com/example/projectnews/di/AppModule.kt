package com.example.projectnews.di

import android.app.Application
import com.example.projectnews.data.manager.LocalUserManagerImpl
import com.example.projectnews.data.remote.NewsApi
import com.example.projectnews.data.repository.NewsRepositoryImpl
import com.example.projectnews.domain.manager.LocalUserManager
import com.example.projectnews.domain.repository.NewsRepository
import com.example.projectnews.domain.usecase.app_entry.AppEntryUseCases
import com.example.projectnews.domain.usecase.app_entry.ReadAppEntry
import com.example.projectnews.domain.usecase.app_entry.SaveAppEntry
import com.example.projectnews.domain.usecase.news.GetNews
import com.example.projectnews.domain.usecase.news.NewsUseCases
import com.example.projectnews.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) : AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi():NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsRepositoryImpl(
        newsApi = newsApi
    )

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ) : NewsUseCases = NewsUseCases(
        getNews = GetNews(
            newsRepository = newsRepository
        )
    )
}