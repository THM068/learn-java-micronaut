package workbench.collections

import scala.collection.mutable

object Main extends App {

  val hasSameElements = Seq(1,2,3).sameElements(Set(1,2,3))

  println(s"Do they contain same elements ${hasSameElements}")

  val set = Seq(1,2,3,3,4).toSet

  println(set)

  val ageList = List(1,2,3)

  println(ageList(1))

  val appendToList = 4 :: ageList
  println(appendToList)
  println(s"prepend to list ${5 +: appendToList}")
  println(s"append to list ${appendToList :+ 7}")
  println(s"filter from list to list ${appendToList.filter( _ > 2)}")

  val daysOftheWeekSet = Set("mon","tue","wed","thur","fri","sat","sun")
  println(daysOftheWeekSet)

  val daysOftheWeekLinkedHashSet = mutable.LinkedHashSet("mon","tue","wed","thur","fri","sat","sun")
  println(daysOftheWeekLinkedHashSet)

  val digits = Set(1, 7, 2, 9)
  println(s"Does digits contain 0 ${digits contains 0}")
  println(s"is (1,7 a subset of digits  ${Set(1,7) subsetOf digits }")
  println(s"Union of digits and (5,8) is ->  ${digits union Set(5,8)}" )
  println(s"add to a set ${digits + 20}")
  println(s"add to a set ${digits - 1}")

  println(s"Added two list ${List(1,2) ++ List(3,4)}")


}
