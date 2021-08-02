package workbench.functional

object Implicits extends App {
  implicit val bool = true

  printIftrue(3)
  def printIftrue(a: Int)( implicit b: Boolean) {
    if(b) println(a)
  }
}
