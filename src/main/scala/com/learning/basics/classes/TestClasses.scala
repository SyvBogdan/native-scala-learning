package com.learning.basics.classes

import java.io

object TestClasses {


  def main(args: Array[String]): Unit = {

    val point1 = new Point
    point1.x = 99
    point1.y = 101 // prints the warning

  //  point1.x_=(98)

    point1.y_=(98)

  //  println(point1)

   val result = returnOrProcess(false)

    println(result)


    type JoinList = (List[String], List[String]) => List[String]

    val concat: JoinList = (list1: List[String], list2: List[String]) => list1:::list2

  }

  def returnOrProcess( boolean: Boolean) =
    if (boolean) println("true") else Int.MaxValue

}
