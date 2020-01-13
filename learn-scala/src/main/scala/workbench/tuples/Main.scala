package workbench.tuples

object Main {

  def main(args: Array[String]): Unit = {
    val x = (3, "kerrie", true)
    println(x._1)
    println(x._2)

    val (name, age, sex) = ("Thomas", 1, "male")
    println(s"my name is ${name} and my age is ${age} and sex ${sex}")
    val y = ("camera", "box").swap
    println(y)

    def lambda = { x :Int => x + 1 }
    println(lambda.apply(2))
    println(lambda(1))

    def multiplier = (i: Int) => i * 10

    println(s" value of multiple is ${multiplier(3)}")

    def summation(x: Int, y: Int => Int) = y(x)

    println( summation(10, x => x +4))

  }
}
