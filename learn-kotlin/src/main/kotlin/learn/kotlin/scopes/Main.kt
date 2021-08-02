package learn.kotlin.scopes

import com.google.gson.Gson
import java.net.URL

fun main() {

    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let(::println)

    Gson().fromJson(URL("http://api.open-notify.org/astros.json").readText(),AstroResult::class.java )
            .people.map { it.name }.let(::println)
}

data class AstroResult(val message: String, val number: Number, val people: List<Assignment>)

data class Assignment(val craft: String, val name: String)