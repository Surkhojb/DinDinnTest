package com.surkhojb.dindinntest.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    var binding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getActivityBinding()
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null

    }

    abstract fun getActivityBinding(): VB
}