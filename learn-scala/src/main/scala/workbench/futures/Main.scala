package workbench.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
object Main extends App {

  Future {
    println("Hello world")
  }
  println("Hey you")


  val list = List(List(Some("Test")), List(Some("Test")))

  println(list.flatten)

  val sum: (Int,Int) => Int = (a,b) => a + b

}
