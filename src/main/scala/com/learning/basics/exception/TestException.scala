package com.learning.basics.exception

object TestException {

  def main(args: Array[String]): Unit = {

    try {

      divideNumber(1, 20)

      throw new RuntimeException("smth else")

    } catch {
      case ex: ZeroDivideException => println(ex.message)
      case another => println(s"another exception - ${another.getMessage}")
    }

    println("Finally with no Exception: " + getValueFromFinally(false))
    println("Finally with is Exception: " + getValueFromFinally(true))

    println("Catch with no Exception: " + getValueFromCatch(false))
    println("Catch with is Exception: " + getValueFromCatch(true))


    println(divideNumberWithoutEx(0, 20))





  }


  def divideNumber(divider: Int, int: Int) =
    if (divider == 0) throw ZeroDivideException("zero dividing rejected")
    else int / divider

  def divideNumberWithoutEx(divider: Int, int: Int) =

    try {
      if (divider == 0) throw ZeroDivideException("zero dividing rejected")
      else int / divider
    } catch {
      case _ => throw ZeroDivideException("zero dividing rejected")
    } finally {
      println("finally")
    }

  def getValueFromFinally(isException: Boolean) = {
    var value = 0;
    try {
      getValueFromCatch(isException)
    } finally {
      value = 4
    }
    value
  }


  def getValueFromCatch(isException: Boolean) = {
    var value = 0;
    try {
      value = 1
      if (isException) {
        throw new RuntimeException()
      }
      value = 2
    } catch {
      case ex => value = 3
    }
    value
  }
}
