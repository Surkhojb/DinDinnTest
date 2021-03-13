package com.surkhojb.dindinntest.ui.products.drink

import com.airbnb.mvrx.MavericksState
import com.surkhojb.dindinntest.model.FoodItem

data class DrinkState(
        val loading: Boolean = false,
        val drinkList: List<FoodItem> = emptyList(),
        val errorMessage: String = ""
): MavericksState{

}