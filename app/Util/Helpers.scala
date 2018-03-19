package Util

import java.nio.charset.StandardCharsets

import play.api.Play

object Helpers {
  def isNotBlank(string: Option[String]) : Boolean = {
    string match {
      case Some(data) => if(data.equals(""))
        false
      else
        true
      case _ => false
    }
  }
  def singleQuoteString(inputString : String): String = {
    val x = "'".concat(inputString).concat("'")
    x
  }


}
