package learn.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

suspend fun main() {
    val x =  flow {
        for (i in 1..10) {
            delay(1000)
            emit(i)
        }
    }

    val y = measureTimeMillis {
        x.buffer(capacity = 5).collect {
            println(it)
        }
    }

    println(y)

    val z = measureTimeMillis {
        x.collect {
            println(it)
        }
    }
    println(z)
}