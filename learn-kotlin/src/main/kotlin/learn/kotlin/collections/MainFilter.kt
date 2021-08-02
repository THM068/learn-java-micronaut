package learn.kotlin.collections

fun main() {
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10  }

    val list = listOf<Int>(3,5,2,7,3,7,2,5,8, 5).chunked(2)
    println(list)
}