package com.surkhojb.dindinntest.data.remote

import com.surkhojb.dindinntest.data.remote.model.FoodDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface FoodApi {
    @GET("pizza")
    fun fetchPizza(): Single<List<FoodDTO>>

    @GET("sushi")
    fun fetchSushi(): Single<List<FoodDTO>>

    @GET("drinks")
    fun fetchDrink(): Single<List<FoodDTO>>

}