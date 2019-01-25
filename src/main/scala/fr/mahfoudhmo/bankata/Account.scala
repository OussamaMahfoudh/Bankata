package fr.mahfoudhmo.bankata

import fr.mahfoudhmo.bankata.utils.HistoryServer

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:55 PM
  */

//Account must be the one who drives all the operations either by calling transactionManager and historyServer
//Just like a 'bridge' between the user and the bank.
class Account (transactionManager: TransactionManager, historyServer: HistoryServer){

  def deposit(amount: Int): Unit = transactionManager.doDeposit(amount)

  def withdraw(amount: Int): Unit = transactionManager.doWithdraw(amount)

  def showAllHistory(): Unit = historyServer.printHistory(transactionManager.giveAllTransactions())

}
