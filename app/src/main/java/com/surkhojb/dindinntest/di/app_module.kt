package com.surkhojb.dindinntest.di

import com.surkhojb.dindinntest.data.*
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
    fun providesBannerRepository(): BannerRepository =
        BannerRepositoryImpl()

    @Provides
    @Singleton
    fun providesFoodRepository(): FoodRepository = FoodRepositoryImpl()

    @Provides
    @Singleton
    fun providesOrderRepository(): OrderRepository =
        OrderRepositoryImpl()
}