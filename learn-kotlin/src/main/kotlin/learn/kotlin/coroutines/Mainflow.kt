package learn.kotlin.coroutines

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

@InternalCoroutinesApi
suspend fun main() {
    println("Calling foo...")
    val flow = foo()
    println("Calling collect...")
    flow.buffer().collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }

    val time = measureTimeMillis {
        ints.buffer(100).collect { println(it) }
    }
    println("Collected in $time ms")
}

fun foo(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}

val ints: Flow<Int> = flow {
    for (i in 1..10) {
        delay(100)
        emit(i)
    }
}