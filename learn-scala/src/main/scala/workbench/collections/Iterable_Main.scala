package workbench.collections

object Iterable_Main extends App {

  val list = List(1,2,3,4,5,6)
  println(s"The head is ${list.head}")
  println(s"The last is ${list.head}")
  println(s"The headOption is ${list.headOption}")
  println(s"The lastOption is ${list.lastOption}")
  println(s"The tail is ${list.tail}")
  println(s"The init is ${list.init}")

  def toInt(s: String): Option[Int] = {
    try {
       Some(Integer.parseInt(s))
    }
    catch {
      case e: Exception => None
    }
  }

  val strings = Seq("1", "2", "foo", "3", "bar")
  println(strings.map(toInt))
  println(strings.flatMap(toInt))

  val lists = List(1,2,3,4,5)

  def g(x: Int) = List(x -1, x , x+ 1)

  println(list.map(g))
  println(list.flatMap(g))

  val map = Map(1 -> "one", 2 -> "two", 3 -> "three")

  println( 1 to map.size flatMap(map.get))

  val x = List(2,5,10,12,15,17)
  println(x groupBy( _ % 2 == 0))

  val stream = 1 #:: 2 #:: 3 #:: 4 #:: Stream.empty
  println(stream.tail)
}
