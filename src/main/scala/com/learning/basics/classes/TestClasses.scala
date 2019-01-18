package com.learning.basics.classes

import java.io

import com.learning.basics.helper.Case

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

    val concat: JoinList = (list1: List[String], list2: List[String]) => list1 ::: list2
    val concat2: (List[String], List[String]) => List[String] = (list1: List[String], list2: List[String]) => list1 ::: list2

    val man1 = new Man(20)

    //  val  man2 = new Man("Vasya", 20)

    //  println(man1 == man2)

    //  println(man1.eq(man2))


    implicit def x(x: Long) = new Rational(x)

    val r = new Rational(2, 3)

    println(2.*(r))

    val a = 1

    val b = 2

    val c = if (a > b) a else b //2


    val case1 = Case.createNewCase("Test val as immutable val", 1)

    val elem = new CompleteElement

    println(elem.width)

    val arr2 = elem.contents

    arr2(0) = "33333333333333333"
    println(elem.width)

    val case2 = Case.createNewCase("Class hierarchy", 1)

    //class AnyExtension extends Any

    val w = new Wrapper(new Man("", 12,""))

   // w.printer()

    case2.endOfCase



    val case3 = Case.createNewCase("Class hierarchy", 3)

    def testImpl( int: Int) = ???

    val  result2: Int => Int = (int : Int) => {
      val int2: Int = testImpl(2)
     int2 * int
    }

    print( result2(2) * 2)

    case3.endOfCase


  }

  def returnOrProcess(boolean: Boolean) =
    if (boolean) println("true") else Int.MaxValue



}

trait BasicWrapper extends Any {
 // val obj = new Object //-- not allowed
  def printer(): Unit = println(this)
}

trait SomeOtherTrait  {
 // val obj = (21,"")
  def print(): Unit = println(this)
}

case class Wrapper(underlying: Man) extends AnyVal with BasicWrapper {

   /*(lazy)*/ //val obj = new Object //- not allowed
  // override def equals(other: Any): Boolean = ??? - not allowed
  // override def hashCode(): Int =  ??? - not allowed

  def test(){}
}




//class ExtendedWrapper extends  Wrapper(2) -- not legal to inherit from Value classes