package com.surkhojb.dindinntest.ui.products.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProductAdapter(
        val activity: FragmentActivity,
        val fragments: List<Fragment>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}