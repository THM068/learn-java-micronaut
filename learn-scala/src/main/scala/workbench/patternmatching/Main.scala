package workbench.patternmatching

object Main {
  def main(args: Array[String]): Unit = {

    def sum(a: Int)(b: Int)( c: Int) = a + b + c

    val part = sum(2)(3)(_: Int)

    println(part(4))
  }

  val secondElement = List(1, 2, 3) match {
    case x :: xs ⇒ xs.head
    case _ ⇒ 0
  }

  println(secondElement)
}

case class Person(name: String)

class TestOne extends A with B

trait A {
  println("hello")
}
trait B {
  println("hello 2")
}
