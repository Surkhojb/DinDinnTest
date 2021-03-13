package com.surkhojb.dindinntest.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.databinding.PaymentFragmentBinding


class CardPaymentFragment : BottomSheetDialogFragment() {
    private lateinit var binding: PaymentFragmentBinding

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {

        binding = PaymentFragmentBinding.bind(inflater.inflate(
            R.layout.payment_fragment, container,
            false))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = arguments?.getString("payment_amount")
        binding.paymentAmount.text = "$amount SGD"
        binding.paymentButton.setOnClickListener { this.dismiss() }
    }

    companion object {
        fun newInstance(): CardPaymentFragment {
            return CardPaymentFragment()
        }
    }
}