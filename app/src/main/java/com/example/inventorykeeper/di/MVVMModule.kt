package com.example.inventorykeeper.di

import android.content.Context
import com.example.inventorykeeper.model.NoteDataSource
import com.example.inventorykeeper.model.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MVVMModule {

    @Provides
    @Singleton
    fun providerRepository(@ApplicationContext application: Context): NoteDataSource {
        return NoteRepository(application)
    }
}