package com.surkhojb.dindinntest.model

data class FoodItem(
    val id: Long,
    val url: String,
    val name: String,
    val description: String,
    val category: FoodCategory,
    val price: Double,
    val units: Int
)

enum class FoodCategory(val category: String) {
    PIZZA("PIZZA"),
    SUSHI("SUSHI"),
    DRINK("DRINK")
}