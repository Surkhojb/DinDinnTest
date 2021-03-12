package com.surkhojb.dindinntest.data.remote

import com.surkhojb.dindinntest.data.remote.model.FoodDTO
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object FoodApi {
    fun fetchPizza(): Single<List<FoodDTO>>{
        return Single.just(buildPizzaList())
            .delay(2, TimeUnit.SECONDS, Schedulers.io())
    }

    fun fetchSushi(): Single<List<FoodDTO>>{
        return Single.just(buildDrinks())
            .delay(2, TimeUnit.SECONDS, Schedulers.io())
    }

    fun fetchDrink(): Single<List<FoodDTO>>{
        return Single.just(buildDrinks())
            .delay(2, TimeUnit.SECONDS, Schedulers.io())
    }

    private fun buildPizzaList() = listOf<FoodDTO>(
        FoodDTO(1,PEPPERONI_URL,"Pepperoni","Classic Pepperoni: Salami, Ham, Bacon, Mushrooms, Green Pepper","PIZZA",8.5,10),
        FoodDTO(2, MARGHARITA_URL,"Margharita","Classic Margharita: Sliced tomato","PIZZA",5.5,10),
        FoodDTO(3, HAWAIIAN_URL,"Hawaiian","Hawaiian: Ham, Pineapple","PIZZA",8.5,10),
        FoodDTO(4, FOUR_CHEESE_URL,"Four cheese","Four cheese: Mozzarella, Cheddar, Parmessan","PIZZA",8.5,10),
        FoodDTO(5, CARBONARA_URL,"Carbonara","Carbonara: Cream, Onion, Mushrooms, Egg","PIZZA",8.5,10),
        FoodDTO(6, CARBONARA_URL,"Carbonara","Carbonara: Cream, Onion, Mushrooms, Egg","PIZZA",8.5,10)

    )

    private fun buildDrinks() = listOf(
        FoodDTO(30, COKE_URL,"Coke","Classi peperoni pizza","pizza",7.5,10),
        FoodDTO(31, DIET_COKE_URL,"Diet Coke","Classi peperoni pizza","pizza",7.5,10),
        FoodDTO(32, BEER_URL,"Beer","Classi peperoni pizza","pizza",7.5,10),
        FoodDTO(33, WATER_URL,"Still water","Classi peperoni pizza","pizza",7.5,10),
        FoodDTO(34, ORANGE_SODA,"Orange Soda","Classi peperoni pizza","pizza",7.5,10)
    )

    private val PEPPERONI_URL = "https://media.gettyimages.com/photos/spicy-sopressata-pizza-picture-id140440997?s=2048x2048"
    private val MARGHARITA_URL = "https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/5802fab5-fdce-468a-a830-43e8001f5a72/Derivates/c00dc34a-e73d-42f0-a86e-e2fd967d33fe.jpg"
    private val HAWAIIAN_URL = "https://assets.blog.foodnetwork.ca/wp-content/uploads/sites/6/2016/04/hawaiian-pizza.jpg"
    private val FOUR_CHEESE_URL = "https://www.insidetherustickitchen.com/wp-content/uploads/2020/07/Quattro-Formaggi-1200px-Inside-the-Rustic-Kitchen-2.jpg"
    private val CARBONARA_URL = "https://www.wellplated.com/wp-content/uploads/2017/02/Carbonara-Pizza-recipe.jpg"



    private val COKE_URL = "https://i0.wp.com/www.eatthis.com/wp-content/uploads/2020/11/coke-glass.jpg?fit=1200%2C879&ssl=1"
    private val DIET_COKE_URL = "https://c.stocksy.com/a/53g400/z9/1114951.jpg"
    private val BEER_URL = "https://spy.com/wp-content/uploads/2020/04/shutterstock_155354765.jpg?w=958&h=599&crop=1"
    private val WATER_URL = "https://media.allure.com/photos/5a7b2102f80e784e34bcf62d/1:1/w_2847,h_2847,c_limit/GettyImages-913796622.jpg"
    private val ORANGE_SODA = "https://cdnimg.webstaurantstore.com/images/products/large/403439/1967317.jpg"
}