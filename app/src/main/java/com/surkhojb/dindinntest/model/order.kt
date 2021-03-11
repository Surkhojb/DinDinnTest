package com.surkhojb.dindinntest.model

import java.util.*

data class Order(
    val id: Long,
    val date: Date,
    val items: List<FoodItem>,
    val amount: Double,
    val phone: String
)