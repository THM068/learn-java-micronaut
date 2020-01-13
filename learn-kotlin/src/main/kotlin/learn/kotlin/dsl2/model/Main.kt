package learn.kotlin.dsl2.model

fun main(){

    val order = order {
       soda(Coke)
       +Sprite
       Dr_Pepper quantity 3

       pizza {
           +Pineapple
       }

       +PepperoniPizza {
           +Olives
       }
    }
    println(order.items.keys)
    order.log()

}