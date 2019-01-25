package fr.mahfoudhmo.bankata

import fr.mahfoudhmo.bankata.utils.Watch

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:44 PM
  */
class TransactionManager(watch: Watch) {

//Needs to be var so that we can reassign as we add to the list some transactions
  private var transactionList: List[Transaction] = List[Transaction]()

  def doDeposit(amount: Int): Unit = {
    transactionList = transactionList :+ Transaction(watch.theDayAsString(), amount)
  }

  def doWithdraw(amount: Int): Unit = {
    transactionList = transactionList :+ Transaction(watch.theDayAsString(), -amount)
  }

  def giveAllTransactions(): List[Transaction] = transactionList

}
