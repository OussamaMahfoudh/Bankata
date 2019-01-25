package fr.mahfoudhmo.bankata

import fr.mahfoudhmo.bankata.utils.HistoryPrinter
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:54 PM
  */
class AccountTest extends FlatSpec with MockFactory {

  behavior of "an Account"

  val transactionManager: MockableTransactionManager = stub[MockableTransactionManager]
  val historyPrinter: MockableHistoryPrinter = stub[MockableHistoryPrinter]

  val transactions = List(Transaction("24/01/2019", 45000))

  val account = new Account(transactionManager, historyPrinter)

  it should "save a deposit transaction" in {
    account.deposit(2050)

    (transactionManager.doDeposit _).verify(2050)
  }

  it should "save a withdrawal transaction" in {
    account.withdraw(3100)

    (transactionManager.doWithdraw _).verify(3100)
  }

  it should "show all transaction history" in {
    (transactionManager.giveAllTransactions _).when().returns(transactions)

    account.showAllHistory()

    (historyPrinter.printHistory _).verify(transactions)
  }

  class MockableTransactionManager extends TransactionManager(null)

  class MockableHistoryPrinter extends HistoryPrinter

}