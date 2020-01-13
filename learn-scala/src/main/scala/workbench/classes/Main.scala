package workbench.classes

object Main {

  def main(args: Array[String]): Unit = {
    val point = new Point(y=3, x=2)
    println(point)

    val someValue: Option[String] = Some("My name is thomas")

    val result = someValue match {
      case Some(v) => v
      case None => "no value specied"
    }

    println(s"The result value is $result")

    val getOrElse = maybeItWillReturnSomething(false).getOrElse("No value specified")
    val optionString = maybeItWillReturnSomething(false)

    assert(optionString.isEmpty, "Should be empty")
    println(s"The value of getOrElse is $getOrElse")
  }

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if(flag) Some("Found value") else None
  }
}
class Point(x: Int, y: Int) {

  override def toString: String = s"($x, $y)"
}