package fr.mahfoudhmo.bankata.utils

import java.util.concurrent.atomic.AtomicInteger

import fr.mahfoudhmo.bankata.Transaction

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 10:05 PM
  */
class HistoryPrinter extends HistoryServer with ConsoleDisplayer {

  private val HEADER = "DATE | AMOUNT | BALANCE"

  override def printHistory(transactions: List[Transaction]): Unit = {
    show(HEADER)
    printTransactions(transactions)
  }

  private def printTransactions(transactions: List[Transaction]): Unit = {
    val balance = new AtomicInteger(0)

    transactions
      .reverse //We reverse the list to have a descending history so the last transaction is shown first
      .map(toLine(_, balance))
      .foreach(show)
  }

  private def toLine(transaction: Transaction, balance: AtomicInteger): String = {
    //If we were to use Double instead of Int we could switch to f interpolator
    s"${transaction.theDate} | ${transaction.theAmount} | ${balance.addAndGet(transaction.theAmount)}"
  }
}
