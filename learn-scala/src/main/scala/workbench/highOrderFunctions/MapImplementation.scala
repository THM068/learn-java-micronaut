package workbench.highOrderFunctions

import java.util
import java.util.UUID

object MapImplementation extends App{

  val double: (Int) => Int = (i) => i * 2
  val filter: (Int) => Boolean  = (i) => i > 2
  val list = List(1,2,3)


  println(map(double, list))
  println(map(filter, list))

  println(invokeLater ())
  def map[A](f: (Int) => A, list: List[Int]) : List[A] = {
    for {
      x <- list
    } yield f(x)
  }

  def filter(f:(Int) => Boolean, list: List[Int]): List[Int] = {
    val l = new util.ArrayList[Int]()
    val result: List[Int] = for {
      x <- list.filter(f)
    } yield (x)
    println(result)
    result
  }

  def invokeLater (blockOfCode: => String = UUID.randomUUID().toString): String = {
      blockOfCode
  }

}


