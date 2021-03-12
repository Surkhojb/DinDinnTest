package com.surkhojb.dindinntest.data.mapper

import com.surkhojb.dindinntest.data.remote.model.FoodDTO
import com.surkhojb.dindinntest.model.FoodCategory
import com.surkhojb.dindinntest.model.FoodItem

fun FoodDTO.toModel() = FoodItem(
    id,
    url,
    name,
    description,
    FoodCategory.valueOf(category),
    price, units
)