package com.surkhojb.dindinntest.di

import com.surkhojb.dindinntest.data.FoodRepository
import com.surkhojb.dindinntest.data.FoodRepositoryImpl
import com.surkhojb.dindinntest.data.remote.BannerRepository
import com.surkhojb.dindinntest.data.remote.BannerRepositoryImpl
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
    fun providesBannerRepository(): BannerRepository = BannerRepositoryImpl()

    @Provides
    @Singleton
    fun providesFoodRepository(): FoodRepository = FoodRepositoryImpl()
}