package com.example.projectnews.di

import android.app.Application
import com.example.projectnews.data.manager.LocalUserManagerImpl
import com.example.projectnews.domain.manager.LocalUserManager
import com.example.projectnews.domain.usecase.AppEntryUseCases
import com.example.projectnews.domain.usecase.ReadAppEntry
import com.example.projectnews.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}