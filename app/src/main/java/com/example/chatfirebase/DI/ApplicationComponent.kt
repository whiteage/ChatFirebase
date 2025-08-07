package com.example.chatfirebase.DI

import com.example.chatfirebase.data.RepositoryImpl
import com.example.chatfirebase.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationComponent {

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return RepositoryImpl()

    }
}