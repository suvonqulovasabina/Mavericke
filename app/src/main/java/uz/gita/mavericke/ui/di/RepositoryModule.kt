package com.example.democomposeproject.ui.di


import uz.gita.mavericke.ui.domain.AppRepository
import uz.gita.mavericke.ui.domain.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun signUpModel(impl: AppRepositoryImpl): AppRepository
}
