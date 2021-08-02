package learn.kotlin.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<String>()
    launch {
        channel.send("A1")
        delay(2000)
        channel.send("A2")
    }

    launch {
        delay(1000)
        channel.send("B1")
    }
    launch {
        repeat(3) {
            val x = channel.receive()
            println(x)
        }
    }
}