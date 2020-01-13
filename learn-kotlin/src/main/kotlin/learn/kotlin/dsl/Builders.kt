package learn.kotlin.dsl

import java.text.SimpleDateFormat
import java.util.Date

@PersonDsl
class PersonBuilder {

    var name: String = ""

    private var dob: Date = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
        }

    private val addresses = mutableListOf<Address>()

    fun addresses(block: ADDRESSES.() -> Unit) {
        addresses.addAll(ADDRESSES().apply(block))
        println(addresses)
    }

    fun build(): Person = Person(name, dob, addresses)

}
@PersonDsl
class ADDRESSES(): ArrayList<Address>() {

    fun address(block: AddressBuilder.() -> Unit) {
        add(AddressBuilder().apply(block).build())
    }

}
@PersonDsl
class AddressBuilder {

    var street: String = ""
    var number: Int = 0
    var city: String = ""

    fun build() : Address = Address(street, number, city)

}