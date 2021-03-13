package com.surkhojb.dindinntest.ui.cart

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.FoodItem
import com.surkhojb.dindinntest.utils.loadUrl

class CartViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val productImage: ImageView = view.findViewById(R.id.cart_item_image)
    private val productName: TextView = view.findViewById(R.id.cart_item_name)
    private val productDescription: TextView = view.findViewById(R.id.cart_item_description)
    private val productPrice: TextView = view.findViewById(R.id.cart_item_price)


    fun bind(item: FoodItem){
        productImage.loadUrl(item.url)
        productName.text = item.name
        productDescription.text = item.description
        productPrice.text = "Price: ${item.price} SGD"
    }

}