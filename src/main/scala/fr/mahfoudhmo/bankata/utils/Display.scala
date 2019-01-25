package fr.mahfoudhmo.bankata.utils

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:50 PM
  */
trait Display[-A] {
//We Could introduce more display options other than the console
//Just some future proofing
  def show(data:A)

}
