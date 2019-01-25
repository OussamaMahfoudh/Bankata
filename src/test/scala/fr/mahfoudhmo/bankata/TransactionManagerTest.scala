package fr.mahfoudhmo.bankata

import fr.mahfoudhmo.bankata.utils.Watch
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:43 PM
  */
class TransactionManagerTest extends FlatSpec
  with BeforeAndAfterEach
  with Matchers
  with MockFactory {

  behavior of "a TransactionRepository"

  val watch: Watch = stub[Watch]

  var transactionManager: TransactionManager = _

  override protected def beforeEach(): Unit = {
    transactionManager = new TransactionManager(watch)
  }

  it should "save a deposit transaction" in {
    (watch.theDayAsString _).when().returns("24/01/2019")

    transactionManager.doDeposit(150000)

    val transactions = transactionManager.giveAllTransactions()

    transactions should have size 1
    transactions should contain(Transaction("24/01/2019", 150000))
  }

  it should "save a withdrawal transaction" in {
    (watch.theDayAsString _).when().returns("24/01/2019")

    transactionManager.doWithdraw(10000)

    val transactions = transactionManager.giveAllTransactions()

    transactions should have size 1
    transactions should contain(Transaction("24/01/2019", -10000))
  }

}