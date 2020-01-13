package learn.kotlin.dsl2.model

import java.util.*

fun order(init: Order.() -> Unit) : Order {
    val order = Order(UUID.randomUUID().toString())
    order.init()
    return order
}

