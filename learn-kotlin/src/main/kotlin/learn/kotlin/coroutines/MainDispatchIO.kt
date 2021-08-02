package learn.kotlin.coroutines

import kotlinx.coroutines.*

suspend fun main() = coroutineScope(){
    println(retrieve())
}

suspend fun retrieve() = withContext(Dispatchers.IO) {
    println(Thread.currentThread().name)
    delay(2000)
    "hello"
}