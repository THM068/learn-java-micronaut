package workbench.currying

object Main extends App {

  val add = plus(3)(_: Int)(6)

  val result = add(4)
  println(result)

  val wrapWithDiv = wrap("<div>")(_: String)("</div>")
  println(wrapWithDiv("<p>Hello, World</p>"))

  val additionCurried = (addition _).curried
  val partialResult = additionCurried(4)(_: Int)(7)

  println(partialResult(9) + " should be 20")

  val wraptWithDiv2 = wrapMethod("<div>", _: String, "</div>")

  println(wraptWithDiv2("<span>I feel pretty</span>"))

  def plus(a: Int)(b: Int)(c: Int) = a + b + c

  def wrap(prefix: String)(html: String)(suffix: String) = prefix + html + suffix

  def addition(a: Int, b: Int, c: Int) = a + b + c

  def wrapMethod(prefix:String, html: String, suffix: String) = prefix + html + suffix

  println("pret".tail + "zel".head + "ay")

  object PigLatinizer {
    def apply(x: => String) = x.tail + x.head + "ay"
  }

  val r = PigLatinizer {
    val x = "pret"
    val z = "zel"
    x ++ z //concatenate the strings
  }

  println(r)
}
