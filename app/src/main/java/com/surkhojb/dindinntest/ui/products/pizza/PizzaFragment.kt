package com.surkhojb.dindinntest.ui.products.pizza

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
import com.surkhojb.dindinntest.utils.visible

class PizzaFragment: Fragment(R.layout.generic_product_fragment), MavericksView {

    private lateinit var binding: GenericProductFragmentBinding
    private  val viewModel: PizzaViewModel by fragmentViewModel()

    private val genericAdapter: GenericAdapter by lazy { GenericAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = GenericProductFragmentBinding.bind(view)
        binding.genericProductList.layoutManager = LinearLayoutManager(requireContext())
        binding.genericProductList.adapter = genericAdapter
    }

    override fun invalidate() = withState(viewModel){ state ->
        binding.genericLoadingIndicator.visible(state.loading)
        if(!state.pizzaList.isNullOrEmpty()){
            handleList(state)
        }
    }

    private fun handleList(state: PizzaState){
        binding.genericProductList.visible(!state.loading)
        genericAdapter.refreshList(state.pizzaList)
    }
}