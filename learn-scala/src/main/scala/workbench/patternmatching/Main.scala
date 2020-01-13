package workbench.patternmatching

object Main {
  def main(args: Array[String]): Unit = {
    val stuff = "blue"

    val mystuff = stuff match {
      case "red" => println("RED"); 1
      case "blue" => println("BLUE"); 2
      case _ => println(stuff); 0
    }
    println(mystuff)

    val foodItem = "porridge"

    def goldieloks(expr: Any) = expr match {
      case (`foodItem`) => "eating"
      case ("chair", "Mama") ⇒ "sitting"
      case ("bed", "Baby") ⇒ "sleeping"
      case _ ⇒ "what?"
    }
  }

  val secondElement = List(1, 2, 3) match {
    case x :: xs ⇒ xs.head
    case _ ⇒ 0
  }

  println(secondElement)
}
