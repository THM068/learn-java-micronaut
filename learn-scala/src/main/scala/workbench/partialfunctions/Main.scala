package workbench.partialfunctions


object Main extends App {

  val divide = new PartialFunction[Int, Int] {
    override def isDefinedAt(x: Int): Boolean = x != 0

    override def apply(x: Int): Int = 42 / x
  }

  val result = if(divide.isDefinedAt(2)) divide(2) else 0
  println(result)



  val convertLowNumToString = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")
    override def isDefinedAt(x: Int): Boolean = x > 0 && x < nums.length

    override def apply(x: Int): String = nums(x -1)
  }

  val convert6to10 = new PartialFunction[Int, String] {
    val nums = Array("six", "seven", "eight", "nine", "ten")
    def apply(i: Int) = nums(i-6)
    def isDefinedAt(i: Int) = i > 5 && i < 11
  }

  val res = if(convertLowNumToString.isDefinedAt(2)) convertLowNumToString(2) else ""

  println(res)

  val anyNum = convertLowNumToString orElse  convert6to10

  println(anyNum(2))
  println(anyNum(9))

  val r = List(0,1,2) collect { divide}
  println(r)

  val rr = List( 43, "two", 3, "one") collect { case i: Int => i + 20}

  println(rr)
}
