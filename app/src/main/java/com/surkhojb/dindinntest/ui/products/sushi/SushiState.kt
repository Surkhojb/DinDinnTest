package com.surkhojb.dindinntest.ui.products.pizza

import com.airbnb.mvrx.MavericksState
import com.surkhojb.dindinntest.model.FoodItem

data class SushiState(
        val loading: Boolean = false,
        val sushiList: List<FoodItem> = emptyList(),
        val errorMessage: String = ""
): MavericksState{

}