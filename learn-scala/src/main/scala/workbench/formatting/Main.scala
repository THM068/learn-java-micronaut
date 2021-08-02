package workbench.formatting

object Main {

  def main(args: Array[String]): Unit = {
    val s = "Hello World"
    println("Application %s".format(s))

    val a = 'a'
    val b = 'b'
    println("Application %c".format(a))
    println("Application %c".format(b))

    val c = 'a'
    println("%c".format(c))
    val d = '\u0061'
    println("%c".format(d))
    val e = '\"'
    println("%c".format(e))
    val f = '\\'
    println("%c".format(f))
    println("""\""")

    val d1 = Dog("Scooby", "Doberman")
    println(d1.toString)

    val nsprofileid = "me"

    println(s" ----> ${nsprofileid eq "me"}")

    var set = Set("a", "b")

    println(set.exists(_ equalsIgnoreCase "a") )
  }
}
case class Dog(name: String, breed: String)
