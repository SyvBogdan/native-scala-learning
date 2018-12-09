package com.learning.basics.exception

object TestException {

  def main(args: Array[String]): Unit = {

    try{

      divideNumber(1, 20)

      throw  new RuntimeException("smth else")

    } catch {
      case ex: ZeroDivideException  => println(ex.message)
      case another => println(s"another exception - ${another.getMessage}")
    }
  }


  def divideNumber( divider: Int ,int: Int) =
    if(divider == 0) throw ZeroDivideException("zero dividing rejected")
    else int / divider

}
