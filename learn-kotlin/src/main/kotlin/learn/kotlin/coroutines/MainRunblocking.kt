package learn.kotlin.coroutines

import kotlinx.coroutines.*

fun main1() = runBlocking<Unit> {
        GlobalScope.launch {
            delay(1000)
            println("World !")
        }
        println("Hello,")
        delay(3000)
    }

fun main2() {
    runBlocking {
        launch {
            println("World")
        }
        println("Hello")
        println("Hola mfethu")
    }
}

fun main() = runBlocking {
    println("show loading....")
    launch {
        println("loaded data = ${loadData1()}")
        val r = retrieve_()
        println(r)
    }
    println("called loadData()")


}

suspend fun loadData1() : Int {
    return loadFromSource1() + loadFromSource2()
}

suspend fun loadFromSource1() : Int {
    delay(1000)
    return 3
}

suspend fun loadFromSource2() : Int {
    delay(4000)
    return 6
}

suspend fun retrieve_() = coroutineScope {
    withContext(Dispatchers.IO + CoroutineName("Kerr")) {
        println("Retrieving data on ${Thread.currentThread().name}")
        delay(500)
        5
    }
}
