package com.surkhojb.dindinntest.ui.products.generic

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.FoodItem
import com.surkhojb.dindinntest.utils.loadUrl



class GenericViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val productImage: ImageView = view.findViewById(R.id.generic_product_image)
    private val productName: TextView = view.findViewById(R.id.generic_product_name)
    private val productDescription: TextView = view.findViewById(R.id.generic_product_description)
    private val productBuy: Button = view.findViewById(R.id.generic_product_btn_buy)


    fun bind(item: FoodItem, action: (FoodItem) -> Unit){
        productImage.loadUrl(item.url)
        productName.text = item.name
        productDescription.text = item.description
        productBuy.text = "${item.price} SGD"

        productBuy.setOnClickListener {
            action(item)
        }
    }
}