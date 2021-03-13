package com.surkhojb.dindinntest.ui.products.drink

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.databinding.GenericProductFragmentBinding
import com.surkhojb.dindinntest.ui.products.generic.GenericAdapter
import com.surkhojb.dindinntest.ui.products.main.ProductEvent
import com.surkhojb.dindinntest.utils.visible
import org.greenrobot.eventbus.EventBus

class DrinkFragment: Fragment(R.layout.generic_product_fragment), MavericksView {

    private lateinit var binding: GenericProductFragmentBinding
    private  val viewModel: DrinkViewModel by fragmentViewModel()

    private val genericAdapter: GenericAdapter by lazy { GenericAdapter { foodItem ->
        EventBus.getDefault().post(ProductEvent())
        viewModel.addToCart(foodItem)
    }}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = GenericProductFragmentBinding.bind(view)
        binding.genericProductList.layoutManager = LinearLayoutManager(requireContext())
        binding.genericProductList.adapter = genericAdapter
    }

    override fun invalidate() = withState(viewModel){ state ->
        binding.genericLoadingIndicator.visible(state.loading)
        if(!state.drinkList.isNullOrEmpty()){
            handleList(state)
        }
    }

    private fun handleList(state: DrinkState){
        binding.genericProductList.visible(!state.loading)
        genericAdapter.refreshList(state.drinkList)
    }
}