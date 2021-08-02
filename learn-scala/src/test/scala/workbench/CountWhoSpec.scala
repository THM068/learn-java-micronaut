package workbench

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CountWhoSpec extends AnyFlatSpec with Matchers {

  "isEven" should "be test" in {
    val isEven = (i: Int) => i % 2 == 0

    isEven(4) shouldBe true
    isEven(5) shouldBe false
  }

  "Filter" should "return 3 elemenst" in {
    val ints = List(1,2,3,4)
    val isEven = (i: Int) => i % 2 == 0

    ints.filter(isEven).size shouldEqual 3
  }

  "Map" should "hold function literals" in {
    val double = (i: Int) => i * 2
    val triple = (i: Int) => i * 3

    val model = Map( "2x" -> double, "3x" -> triple)

    val dub = model.get("2x")

    dub.get.apply(2) shouldEqual(4)


    val map = Map("2x" -> triple)


  }

  def triple(i: Int) = i * 3
}
