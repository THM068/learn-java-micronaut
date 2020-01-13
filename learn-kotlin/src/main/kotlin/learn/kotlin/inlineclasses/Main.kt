package learn.kotlin.inlineclasses

fun student(name: Name, surname: Surname) {
    println("The name is ${name.name} ${surname.surname}")
}

fun main() {
    student(Name("Thando"), Surname("Mafela") )
}

inline class Name(val name: String)
inline class Surname(val surname: String)