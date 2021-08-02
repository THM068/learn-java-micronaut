package workbench.highOrderFunctions
import scala.math._

object Main extends App {
  val num = 3.14
  val fun = ceil _

  println(fun(num))

  val f:(Double) => Double = ceil

  println(f(num))

  val result = Array(3.14, 1.42, 2.0).map(fun)
  println(result.mkString(","))

  val triple = (x: Double) => x * 3

  println(Array(3.14, 1.42, 2.0).map(fun).map(triple).mkString(",") )

  println( Array(3.14, 1.42, 2.0) map fun map triple mkString "," )

  println("------------------------------")

  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  println(valueAtOneQuarter { ceil _ })
  println(valueAtOneQuarter(sqrt _))

  println( valueAtOneQuarter(3 * _) )

  def mulby(factor: Double) = (x: Double) => factor * x
  val quintuple = mulby(5)
  println(quintuple(20))

  val stringLengthFun = (_: String).length

  println(stringLengthFun("Thando"))
  println( (1 to 9).map( 0.1 * _ ))

  (9 to 1 by -1).map("*" * _).foreach( println _)

  def until(condition: => Boolean)(block: => Unit): Unit = {
    if(!condition) {
      block
      until(condition)(block)
    }
  }

  var x = 10
  until(x == 0) {
    x -= 1
    println(x)
  }

  val mulOneAtTime = (x: Int) => ((y: Int) => x * y )
  val curriedFun = mulOneAtTime(6)

  println(curriedFun(7))
}
