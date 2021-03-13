package com.surkhojb.dindinntest.data.local

import com.surkhojb.dindinntest.model.FoodItem
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object CartDb {
    private val shoppinList: MutableList<FoodItem> = mutableListOf()

    fun addToShoppingList(item: FoodItem) = shoppinList.add(item)

    fun getShoppingCart(): Single<List<FoodItem>>{
        return Single.just(shoppinList.toList()).delay(1, TimeUnit.SECONDS, Schedulers.io())
    }
}