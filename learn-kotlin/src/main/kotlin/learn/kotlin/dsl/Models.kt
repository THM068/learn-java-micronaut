package learn.kotlin.dsl
import java.util.*

@DslMarker
annotation class PersonDsl

data class Person(val name: String,
                  val dateOfBirth: Date,
                  val addresses: List<Address>)


data class Address(var street: String,
                   var number: Int,
                   var city: String)