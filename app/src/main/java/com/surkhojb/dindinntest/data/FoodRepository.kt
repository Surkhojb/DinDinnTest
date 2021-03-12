package com.surkhojb.dindinntest.data

import com.surkhojb.dindinntest.data.remote.FoodApi
import com.surkhojb.dindinntest.data.remote.model.FoodDTO
import io.reactivex.rxjava3.core.Single

interface FoodRepository {

    fun fetchPizza(): Single<List<FoodDTO>>

    fun fetchSushi(): Single<List<FoodDTO>>

    fun fetchDrink(): Single<List<FoodDTO>>
}

class FoodRepositoryImpl(
): FoodRepository {

    override fun fetchPizza() = FoodApi.fetchPizza()

    override fun fetchSushi() = FoodApi.fetchSushi()

    override fun fetchDrink() = FoodApi.fetchDrink()
}