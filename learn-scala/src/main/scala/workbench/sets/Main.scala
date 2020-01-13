package workbench.sets

object Main {

  def main(args: Array[String]): Unit = {
    val myset = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    println(myset.size)
    val newset = myset + "Illinois"
    println(s"illinois found in newset ${newset.contains("Illinois")}")

    println(s"check id iowa exists ${myset("Iowa")}")
    println(s"check id iowa exists ${myset.apply("Iowa")}")

    val anewSet = myset - "Iowa"
    println(s"In anewSet Iowa is not present ${!anewSet.apply("Iowa")}")

    val smallSet = myset -- List("Wisconsin", "Iowa")
    println(s"Smallset does not contain  iowa ${!smallSet.apply("Iowa")}")
    println(s"Smallset does not contain  Wisconsin ${!smallSet.apply("Wisconsin")}")

    val removeByTuple = myset - ("Wisconsin", "Iowa")
    println( removeByTuple )

    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")

    val instersectSet = mySet1 intersect mySet2
    println(s"The intersect result is ${instersectSet}")

    val unionSet = mySet1 union mySet2
    println(s"The union is ${unionSet}")

    val diffSet = mySet1 diff mySet2
    println(s"The diff set is ${diffSet}")


  }

}
