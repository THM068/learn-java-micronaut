package workbench.lists

object Main {
  def main(args: Array[String]): Unit = {
    val a = List(1,2,3)

    a.headOption match {
      case Some(1) => println("one")
      case Some(2) => println("two")
      case Some(3) => println("three")
      case _ => println("other")
    }

    println(s"The tails is ${a.tail}")

    a.foreach( a => println(a))
    val nameList = List("Thomas", "Kerrie", "Thando")

    println(nameList(0))
    println(nameList(2))
    println(nameList(1))

    val x = List(1, 3, 5, 7, 9)
    println( x.filter( x => x <=3))
    println( x.filterNot( x => x <=3))
    println(x.reverse)
    println( x.map( x => x * 2))

    val aa = List(1, 2, 3)

    println(aa.map( _ * 2))

    val ab = List(1, 3, 5, 7)
    println( s"reduceleft ${ab.reduceLeft( _ + _ )}")
    println( s"reduceleft ${ab.reduceLeft( _ * _ )}")
    println(s"min ${ab.reduceLeft( (a,b) => a min b)}")
    println(s"max ${ab.reduceLeft( (a,b) => a max b)}")

    println("fold left")
    println(ab.foldLeft(0)((a,b) => a + b))
    println(ab.foldLeft(10)((a,b) => a + b))

    val newList = 0::ab
    println(newList)

    val dd = Nil
    val cc = 3 :: dd
    val bb = 2 :: cc
    val aaa = 1 :: bb

    println(aaa)
    println(aaa.tail)
    println(bb.tail)
    println(cc.tail)

    val l = List(0, 1, 2, 3)
    val ll = List(4) ::: l
    println(s"new list ll is ${ll}")


  }
}
