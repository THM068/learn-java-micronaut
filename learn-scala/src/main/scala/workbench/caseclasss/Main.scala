package workbench.caseclasss

object Main {

  def main(args: Array[String]): Unit = {
    val p = Person(name = "Thomas", surname = "Mafela")
    val a = Person(name = "Thomas", surname = "Mafela")

    assert( p == a)
    assert( !(p eq a))

    val aa = "a"
    val bb = "a"

    assert( aa == bb)
    assert( aa eq bb)
  }

}

case class Person(val name: String, val surname: String)
