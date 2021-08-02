package learn.kotlin.coroutines

import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    val x = async {
        println(Thread.currentThread().name)
        delay(1500)
        5+3
    }
    val y = async {
        println(Thread.currentThread().name)
        delay(1000)
        9+1
    }

    val result = x.await() + y.await()
    println(result)
}

fun main_1() = runBlocking { // this: CoroutineScope
    launch {
        delay(200L)
        println("Task from runBlocking")
    }
    withContext(Dispatchers.IO) {}
    coroutineScope { // Creates a coroutine scope
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // This line will be printed before the nested launch
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
}