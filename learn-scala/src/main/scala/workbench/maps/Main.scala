package workbench.maps

object Main {
  def main(args: Array[String]): Unit = {
    val map = Map( "thando" -> "Zim", "Sipho" -> "USA", "Thabo" -> "MI")

    println(s"the value of apply(key) ${map.apply("thando")}" )
    println(s"the definedAt  ${map.isDefinedAt("Thabo")}" )

    val newMap = map + ("Thomas" -> "GB", "Kerrie" -> "GB")
    val d = map + ("Thomas" -> "ZW")
    println(newMap)
    println(d)

    val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan") withDefaultValue "missing data"
    println(myMap.head)
    println(myMap("MIX"))

    val newMp = myMap - "WI"
    println(newMp)

    println(myMap -- List("MI", "WI"))
    println(myMap - ("MI", "WI"))
  }
}
