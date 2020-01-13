package learn.kotlin.higherorder

import java.io.Closeable
import java.math.BigDecimal

data class Person(val name: String)
fun add(x: Int, y: Int ) = x + y

fun higherOrder(x: Int, y: Int, func: (Int, Int) -> Int) = func(x, y)

fun main() {
    val result = higherOrder(4,5, ::add)
    println(result)
    println(higherOrder(5,6) { x, y ->
        x + y
    })

    val p = Person("Thando")

    p shouldEqual Person("Thando")

    val bd = 1.bd

}

fun using(obj: Closeable, block:() -> Unit) {

    try {
        block()
    }
    finally {
        obj.close()
    }

}

infix fun Any.shouldEqual(any: Any) {

    assert(this == any)
}

private val Int.bd: BigDecimal
    get() {
        return BigDecimal(this)
    }