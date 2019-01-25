package fr.mahfoudhmo.bankata.utils

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:52 PM
  */
trait ConsoleDisplayer extends Display[String]{
  override def show(data: String): Unit = println(data)
}
