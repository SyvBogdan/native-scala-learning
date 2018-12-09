package com.learning.basics.classes

import java.io

class TestClasses(val digit: Int)

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

    val testClasses = new TestClasses(1)

    val testClassesObj = TestClasses

    type JoinList = (List[String], List[String]) => List[String]

    val concat: JoinList = (list1: List[String], list2: List[String]) => list1:::list2
    val concat2: (List[String], List[String]) => List[String] = (list1: List[String], list2: List[String]) => list1:::list2

    val  man1 = new Man(20)

  //  val  man2 = new Man("Vasya", 20)

  //  println(man1 == man2)

  //  println(man1.eq(man2))


    implicit def x(x: Long) = new Rational(x)

    val r = new Rational(2, 3)

    println( 2.*(r) )

    val a = 1

    val b = 2

    val c = if (a > b) a else b //2

  }

  def returnOrProcess( boolean: Boolean) =
    if (boolean) println("true") else Int.MaxValue

}
