package fr.mahfoudhmo.bankata.utils

import fr.mahfoudhmo.bankata.Transaction

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 10:07 PM
  */
trait HistoryServer {
//We use self type for some DI functionality, clearly overkill in our use case.
  this: Display[Nothing] =>
  def printHistory(transactions: List[Transaction])
}
