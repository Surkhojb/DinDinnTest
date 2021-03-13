package com.surkhojb.dindinntest.ui.products.pizza

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.surkhojb.dindinntest.data.FoodRepository
import com.surkhojb.dindinntest.data.mapper.toModel
import com.surkhojb.dindinntest.di.mvrx.AssistedViewModelFactory
import com.surkhojb.dindinntest.di.mvrx.hiltMavericksViewModelFactory
import com.surkhojb.dindinntest.model.FoodItem
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class PizzaViewModel @AssistedInject constructor (@Assisted initialState: PizzaState,
                                                  val foodRepository: FoodRepository): MavericksViewModel<PizzaState>(initialState) {
    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    init {
        fetchPizzas()
    }

    private fun fetchPizzas(){
        setState { copy(loading = true)}
        val disposable = foodRepository.fetchPizza()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list, error ->
                    if(!list.isNullOrEmpty()){
                        setState {
                            copy( loading = false,pizzaList = list.map { it.toModel() })
                        }
                    }else{
                        setState {
                            copy(false, emptyList(), error.localizedMessage)
                        }
                    }
                }

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun addToCart(foodItem: FoodItem) {
        foodRepository.addToCart(foodItem)
    }

    @AssistedFactory
    interface Factory :
        AssistedViewModelFactory<PizzaViewModel, PizzaState> {
        override fun create(state: PizzaState): PizzaViewModel
    }

    companion object : MavericksViewModelFactory<PizzaViewModel, PizzaState> by hiltMavericksViewModelFactory()
}