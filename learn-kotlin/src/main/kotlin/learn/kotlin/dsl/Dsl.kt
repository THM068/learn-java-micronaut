package learn.kotlin.dsl

fun person(block: PersonBuilder.() -> Unit): Person = PersonBuilder().apply(block).build()



fun main() {

    val person = person {
        name = "John"
        dateOfBirth = "1980-12-01"
        addresses {
            address {
                street = "Main Street"
                number = 12
                city = "London"
            }
            address {
                street = "Dev Avenue"
                number = 42
                city = "Paris"
            }
        }
    }

    println(person)
}