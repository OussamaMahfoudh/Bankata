package fr.mahfoudhmo.bankata.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
  * User: Mahfoudh 
  * Date: 1/24/2019 9:26 PM
  */
class Watch {

  val DD_MM_YYYY: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

  def theDayAsString() : String = theDay().format(DD_MM_YYYY)

  protected def theDay(): LocalDate = LocalDate.now()

}
