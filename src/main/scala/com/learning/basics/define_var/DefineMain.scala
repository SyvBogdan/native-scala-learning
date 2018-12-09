package com.learning.basics.define_var

import scala.collection.mutable

object DefineMain {
  def main(args: Array[String]): Unit = {

    val msg:String = "Variable with define output type"
    val msg2 = "Variable without define output type"
    val map = mutable.Map[Int, String]()
    map += (1 -> "val")
    val anotherMap = (2->"Val2", 3->"Val3")

    val concat = (list1: List[String], list2: List[String]) => list1::list2
    val concatAnother = (_: List[String]) ::: (_: List[String])
    val maxInt = max(3,4)
    println(maxInt)
  }

  def max(x:Int, y:Int):Int = {
    val list = List[Int](x,y)

    val additionalList = List(1,2,3)
    val total = for {value <- list if value > 0;addValue <- additionalList if additionalList.nonEmpty}
      /*println(value + " " + addValue)*/ yield value+addValue

    list.foreach(println)
    list.foreach(println _)
    list.foreach(x => println(x))

    if (x>y) x else y
  }

  def min (x:Int, y:Int):Int = if (x < y) x else y

  def print():Unit = println("Message")
  def printAnother() = println("Message")
}
