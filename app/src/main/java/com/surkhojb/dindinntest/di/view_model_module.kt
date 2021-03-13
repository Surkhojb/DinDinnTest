package com.surkhojb.dindinntest.di

import com.airbnb.mvrx.MavericksViewModel
import com.surkhojb.dindinntest.di.mvrx.AssistedViewModelFactory
import com.surkhojb.dindinntest.di.mvrx.MavericksViewModelComponent
import com.surkhojb.dindinntest.ui.products.drink.DrinkViewModel
import com.surkhojb.dindinntest.ui.products.pizza.PizzaViewModel
import com.surkhojb.dindinntest.ui.products.pizza.SushiViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(PizzaViewModel::class)
    fun pizzaViewModelFactory(factory: PizzaViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(SushiViewModel::class)
    fun sushiViewModelFactory(factory: SushiViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(DrinkViewModel::class)
    fun drinkViewModelFactory(factory: DrinkViewModel.Factory): AssistedViewModelFactory<*, *>
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ViewModelKey(val value: KClass<out MavericksViewModel<*>>)