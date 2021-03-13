package com.surkhojb.dindinntest.ui.cart

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.FoodItem
import com.surkhojb.dindinntest.utils.inflate

class CartAdapter : RecyclerView.Adapter<CartViewHolder>(){

    private val cartItems: MutableList<FoodItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = parent.inflate(R.layout.cart_item)
        return CartViewHolder(view)
    }

    override fun getItemCount() = cartItems.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.bind(item)
    }

    fun refreshList(items: List<FoodItem>){
        cartItems.addAll(items)
        notifyDataSetChanged()
    }
}