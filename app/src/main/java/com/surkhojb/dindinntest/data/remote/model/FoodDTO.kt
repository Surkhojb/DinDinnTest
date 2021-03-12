package com.surkhojb.dindinntest.data.remote.model


data class FoodDTO(
    val id: Long,
    val url: String,
    val name: String,
    val description: String,
    val category: String,
    val price: Double,
    val units: Int
)