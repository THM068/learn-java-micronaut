package learn.kotlin.coroutines

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
                fetchData()
        }

        println("it is over ...")
    }
}

suspend fun fetchData() {
    val result = get("developer.android.com")
    println("The result is $result" )
}

suspend fun get(url: String) = withContext(Dispatchers.IO){
    delay(5000)
     "Hello World"
}