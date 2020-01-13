package learn.kotlin.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
        GlobalScope.launch {
            delay(1000)
            println("World !")
        }
        println("Hello,")
        delay(3000)
    }
