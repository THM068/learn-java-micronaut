package workbench.json

object Main {

  val p = new Person("hello")
  println(p)

}

case class Person(name: String, age: String = "age")

class Name(name: String) {

  }
