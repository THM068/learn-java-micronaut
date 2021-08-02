package workbench.traits

object MainExample extends App {
  val o1 = new Optouts(Some(true),Some(true),Some(true),Some(true))
  val o2 = new Optouts(Some(true),Some(true),Some(false),Some(true))

  val data1 = new Data(before = Some(o1), after = Some(o2))
  println(o1.equals(o2))
  println(data1.after.equals(data1.before))

 // val b1 = data1.before.get
 // val b2 = data1.after.get

  val result = for {
    b1 <- data1.before
    b2 <- data1.after

  } yield (!(b1.globalBookmarking.equals(b2.globalBookmarking)) || !(b1.personalisedrecsoptout.equals(b2.personalisedrecsoptout)) )

  println(s"The result is ${result}")
//  if( !(b1.globalBookmarking.equals(b2.globalBookmarking)) || !(b1.personalisedrecsoptout.equals(b2.personalisedrecsoptout))  )

  data1.after.map(_.globalBookmarking).getOrElse(None) != None

}

case class Data(before: Option[Optouts], after: Option[Optouts])

case class Optouts(thirdpartymarketingoptout: Option[Boolean],
                   marketresearchoptout: Option[Boolean],
                   personalisedrecsoptout: Option[Boolean],
                   globalBookmarking: Option[Boolean],
                  )

