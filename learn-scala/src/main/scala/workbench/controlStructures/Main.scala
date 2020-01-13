package workbench.controlStructures

object Main {

  def main(args: Array[String]): Unit = {
    val x = 33
    val s = if( x < 20) "small" else "big"
    println(s)

   val p = new Person()
    p("kerrie")
  }
}

class Person() {

  def apply(name: String): Unit ={
    println(s"Thando Mafela ${name}")
  }
}