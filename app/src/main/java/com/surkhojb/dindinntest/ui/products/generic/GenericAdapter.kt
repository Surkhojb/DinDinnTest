package com.surkhojb.dindinntest.ui.products.generic

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.FoodItem
import com.surkhojb.dindinntest.utils.inflate

class GenericAdapter(private val action: (FoodItem) -> Unit): RecyclerView.Adapter<GenericViewHolder>() {

    private val foodItems: MutableList<FoodItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
       val view = parent.inflate(R.layout.generic_product_item)
       return GenericViewHolder(view)
    }

    override fun getItemCount() = foodItems.size

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val item = foodItems[position]
        holder.bind(item,action)
    }

    fun refreshList(items: List<FoodItem>){
        foodItems.clear()
        foodItems.addAll(items)
        notifyDataSetChanged()
    }
}