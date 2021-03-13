package com.surkhojb.dindinntest.data

import com.surkhojb.dindinntest.data.local.CartDb
import com.surkhojb.dindinntest.data.remote.FoodApi
import com.surkhojb.dindinntest.data.remote.model.FoodDTO
import com.surkhojb.dindinntest.model.FoodItem
import io.reactivex.rxjava3.core.Single

interface FoodRepository {

    fun fetchPizza(): Single<List<FoodDTO>>

    fun fetchSushi(): Single<List<FoodDTO>>

    fun fetchDrink(): Single<List<FoodDTO>>

    fun addToCart(item: FoodItem): Boolean
}

class FoodRepositoryImpl(
): FoodRepository {

    override fun fetchPizza() = FoodApi.fetchPizza()

    override fun fetchSushi() = FoodApi.fetchSushi()

    override fun fetchDrink() = FoodApi.fetchDrink()

    override fun addToCart(item: FoodItem) = CartDb.addToShoppingList(item)
}