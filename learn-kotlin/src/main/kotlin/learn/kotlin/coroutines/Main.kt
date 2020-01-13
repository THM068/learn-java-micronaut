package learn.kotlin.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {

    val deferred: Deferred<Int> = async {
        loadData()
    }
    println("waiting...")
    println(deferred.await())
    println("Finished ....")
}
suspend fun loadData(): Int {
    println("loading...")
    delay(5000L)
    println("loaded!")
    return 42
}
fun flashCards() : List<FlashCard> {
    return listOf(FlashCard("purchase", "buy"))
}

data class FlashCard(val term: String, val definition: String)

fun test(name: String = "Thando"): Unit {
    println("The name is $name")
}