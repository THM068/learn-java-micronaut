package workbench.classes

object Main {

  def main(args: Array[String]): Unit = {
    val point = new Point(y=3, x=2)

    point.name = "Thando"
    println(point)
    println(point.name)

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

    val fred = new Person()
    fred.age = 30
    fred.age = 21
    println(s"Freds age ${fred.age}")

    val message = new Message()
    println(message.timestamp)
    println(message.timestamp)

    val person = new Person("Thomas")
    val kerrie = new Person("Kerrie", 45)

    println(person.name)
    println(person.height)

    println(kerrie.name)
    println(kerrie.height)

    println("-----------------")
    println(Account.timestamp)
    println(Account.timestamp)

  }

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if(flag) Some("Found value") else None
  }


}
class Point(x: Int, y: Int) {
  var name: String = ""
  override def toString: String = s"($x, $y)"
}

class Message {
  val timestamp = java.time.Instant.now.getEpochSecond
}

class Person {
  private var privateAge = 0
  var name = "Thomas"
  var height = 23

  def this(name: String) = {
    this()
    this.name = name
  }

  def this(name: String, height: Int) = {
    this(name)
    this.height = height
  }

  def age = privateAge
  def age_= (newValue: Int) {
    if(newValue > privateAge) privateAge = newValue;
  }
}

object Account {

  def timestamp() = {
    java.time.Instant.now().getEpochSecond
  }
}