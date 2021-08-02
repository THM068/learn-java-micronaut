package workbench.functional

object Countwho extends App {
  val input = Seq[String]("tma24    console  Jul 21 20:32", "tma24    ttys000  Jul 22 20:33", "tma24    ttys001  Jul 22 20:34", "tma24    ttys004  Jul 23 10:52")

  def cut(input: Seq[String], delimeter: String, pos: Int) : Seq[String] = {
      input.map( _.split(delimeter).head)
  }

  def uniq(input: Seq[String])= input.distinct

  def wc(input: Seq[String]) = input.size

  val result = wc(uniq(cut(input," ", 0)))

  println(result)

  val isEven = (i: Int) => i % 2 == 0

  val tr = triple _


  def triple(i: Int) =  i * 3

  def double(i: Int) = i * 2

  val map = Map("2x" -> double _, "3x" -> triple _)

  val list = List(triple _, double _)

  println(list.map( _(3)))


}




