package com.learning.basics.partialfunction

import com.learning.basics.helper.Case

import scala.util.{Failure, Success, Try}

object PartialFunctionTest {

  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("general representation ", 1)

    val calcDevide: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {

      override def isDefinedAt(x: Int): Boolean = {
        x != 0
      }

      override def apply(v1: Int): Int = {
        100 / v1
      }

    }

    if (calcDevide.isDefinedAt(0)) {
      calcDevide(0)
    }


    case1.endOfCase


    val case2 = Case.createNewCase("Test general partial function", 2)


    val evenCondition = (int: Int) => (int % 2) == 0

    val oddCondition = (int: Int) => (int % 2) != 0

    def calcResult(inputVal: Int, calcCond: Int => Boolean) = {

      val result: String = Try {

        val partFunc: PartialFunction[Int, Int] = {
          case x if /*is defined at*/ calcCond(x) => /*function*/ x * 2
          case _ => 0
        }
        // execute it
        partFunc(inputVal)

      } match {
        case Success(value) => "partial function result: " + value
        case Failure(exception) => "Exception has occurred: " + exception

      }
      result
    }

    def divideForEven(int: Int) = println(calcResult(int, evenCondition))

    def divideForOdd(int: Int) = println(calcResult(int, oddCondition))

    divideForEven(3)

    divideForOdd(2)

    case2.endOfCase

    val case3 = Case.createNewCase("Test  partial function for summarize", 2)

    // general function
    val sum = (a: Int, b: Int, c: Int) => a + b + c


    val partEvenFunction: PartialFunction[Int, Int] = {
      case input if (input % 2) != 0 => 0
    }

    val exaggerate = (a: Int, b: Int, c: Int) => {
      sum(a, b, partEvenFunction(c))
    }
    println(partEvenFunction.applyOrElse(3, (x: Int) => sum(2, 3, x)))

    case3.endOfCase

    val case4 = Case.createNewCase("Test  partial function for summarize", 2)

    val getFromOracle = (int: Int) => int * 2

    val getFromFile = (int: Int) => int * 3

    val resultFinihed: PartialFunction[Int, String] = {
      case res if res != null => s"Succefully finished with Result $res"
    }

    val getFromDb: PartialFunction[Int, Int] = {
      case x if x > 0 => getFromOracle(x)
    }

    val getFromAnotherSource: PartialFunction[Int, Int] = {
      case x if x <= 0 => getFromFile(x)
    }

    val getResult: PartialFunction[Int, String] = (getFromDb orElse getFromAnotherSource) andThen resultFinihed

    println(getResult(-3))

    case4.endOfCase

  }
}
