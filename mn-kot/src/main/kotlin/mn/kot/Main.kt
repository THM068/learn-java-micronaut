package mn.kot

fun main() {
    println("-----")
    call { name ->
        println("${this.toUpperCase()} $name")
    }
    println("-----")
    2.days(ago)
}

fun call(greet: String.(String) -> Unit) {
//    greet("Hello", "Jane")
    "Hello".greet("Jane!!")
}

val ago = "ago"

fun Int.days(tense: String) {
    print("called")
}