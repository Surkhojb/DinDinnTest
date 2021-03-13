package com.surkhojb.dindinntest.data

import com.surkhojb.dindinntest.data.local.CartDb
import com.surkhojb.dindinntest.model.FoodItem
import io.reactivex.rxjava3.core.Single

interface OrderRepository {

    fun getShoppingCart(): Single<List<FoodItem>>
}

class OrderRepositoryImpl: OrderRepository {

    override fun getShoppingCart() = CartDb.getShoppingCart()

}