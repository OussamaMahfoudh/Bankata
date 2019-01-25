package fr.mahfoudhmo.bankata.utils

import java.time.LocalDate

import org.scalatest.{FlatSpec, Matchers}

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:27 PM
  */
class WatchTest extends FlatSpec with Matchers {

  behavior of "the watch"

  val watch: Watch = new TestableWatch()

  it should "return today in mm/dd/yyyy format" in {
    watch.theDayAsString() shouldBe "24/01/2019"
  }

  class TestableWatch extends Watch {
    override protected def theDay(): LocalDate = LocalDate.of(2019, 1, 24)
  }

}