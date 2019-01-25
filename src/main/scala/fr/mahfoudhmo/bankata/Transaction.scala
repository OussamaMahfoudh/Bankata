package fr.mahfoudhmo.bankata

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:37 PM
  */
//Here we use a case class because we need immutability as transaction is a dto like entity
//Also for the companion object
//No need to store the balance as it can be calculated easily without any performance hits
case class Transaction(theDate: String, theAmount: Int)
