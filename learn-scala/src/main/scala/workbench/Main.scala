package workbench
import scala.math._
object Main  {

  def main(args: Array[String]): Unit = {
    println("Hello world");

    println(1.toString)

    for( i <- 1 to 3) {
      println(s"the number is ${i}")
    }

    println(s"${99.44.toInt}")

    Math sqrt 4

    println(s"Hello"(3))

    println(BigInt("34"))

    val names = Array("Thando", "Kerrie", "Thomas")

    for( name <- names) {
      println(name)
    }

    println("hello"(0))

    val name = "AmazingDolemite"
    println(s"take == ${name.take(3)}")

    println(s"Takeright == ${name.takeRight(4)}")

    println(s"drop ${name.drop(2)}")

    println(s"dropRight ${name.dropRight(4)}")
  }
}
