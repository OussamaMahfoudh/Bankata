package fr.mahfoudhmo.bankata

import fr.mahfoudhmo.bankata.utils.{HistoryPrinter, Watch}

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 10:31 PM
  */
object BankRunner {
  def main(args: Array[String]): Unit = {


  val watch: Watch = new Watch
  val transactionManager: TransactionManager = new TransactionManager(watch)
  val historyPrinter: HistoryPrinter = new HistoryPrinter
  val account: Account = new Account(transactionManager, historyPrinter)

  account.deposit(100000) //first deposit
  account.withdraw(4500)  //first withdrawal
  account.deposit(2000000)

  account.showAllHistory()
  }
}
