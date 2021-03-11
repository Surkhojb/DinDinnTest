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
    private val foodApi: FoodApi
): FoodRepository {

    override fun fetchPizza() = foodApi.fetchPizza()

    override fun fetchSushi() = foodApi.fetchSushi()

    override fun fetchDrink() = foodApi.fetchDrink()
}