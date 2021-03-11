package com.surkhojb.dindinntest.ui.common

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class DisposableViewModel(): ViewModel() {

    private val compositeDisposable by lazy {  CompositeDisposable() }

    fun addDisposable(disposable: Disposable?){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}