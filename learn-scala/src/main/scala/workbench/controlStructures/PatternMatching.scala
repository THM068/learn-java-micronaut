package workbench.controlStructures
import scala.util.Random

object PatternMatching {

  def main(args: Array[String]): Unit = {
    val x = Random.nextInt(10)

    val result = x match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case _ => "other"
    }

    println(result)
  }

  val left = 2
  val right = 3

  assert(left == right)
}

abstract class Notification {

}