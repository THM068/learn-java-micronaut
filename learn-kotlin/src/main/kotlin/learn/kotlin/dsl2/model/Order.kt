package learn.kotlin.dsl2.model

@DslMarker
annotation class ItemTagMarker

class Order(val id: String) : Item("Order") {
    val items: MutableMap<Item, Int> = mutableMapOf()

    fun soda(soda: Soda) = items.put(soda, items.getOrDefault(Coke,0) + 1)

    operator fun Soda.unaryPlus() = this@Order.soda(this)

    infix fun Soda.quantity(quantity: Int) {
        this@Order.items.put(this, this@Order.items.getOrDefault(this,0) + 1)
    }

    fun pizza(init: Pizza.() -> Unit) {
        val pizza = BuildYourOwn()
        pizza.init()
        items[pizza] = 1
    }

    operator fun Pizza.unaryPlus() {
        this@Order.items.put(this, this@Order.items.getOrDefault(this, 0) + 1)
    }

    fun log() {
        println("Order: $id")
        println("Items")
        items.forEach {
            print("${it.value} x ")
            it.key.log("  ")
        }
    }
}

@ItemTagMarker
abstract class Item(val name: String) {
    open fun log(indent: String = "") {
        println("$indent$name")
    }
}


sealed class Soda(name: String): Item(name)
object Coke: Soda("Coke")
object Sprite: Soda("Sprite")
object Dr_Pepper: Soda("Dr Pepper")

sealed class Topping(name: String): Item(name)
object Pepperoni : Topping("Pepperoni")
object Olives : Topping("Olives")
object Pineapple : Topping("Pineapple")

sealed class Pizza(name: String): Item(name) {
    val toppings:MutableList<Topping> = mutableListOf()

    operator fun Topping.unaryPlus() = this@Pizza.toppings.add(this)

    override fun log(indent: String) {
        super.log(indent)
        toppings.forEach {
            println("$indent      ${it.name}")
        }
    }
}

class BuildYourOwn(init: Pizza.()-> Unit = {}) : Pizza("Build Your Own Pizza") {

    init {
        init.invoke(this)
    }
}


class PepperoniPizza(init: Pizza.() -> Unit = {}): Pizza("Pepperoni Pizza") {

    init {
        +Pepperoni
        init.invoke(this)
    }
}
