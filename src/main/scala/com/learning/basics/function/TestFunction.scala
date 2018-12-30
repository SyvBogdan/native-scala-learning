package com.learning.basics.function

import java.io.{File, OutputStream, PrintWriter}
import java.nio.file.{Path, Paths}
import java.util.Date

import com.learning.basics.helper.Case

import scala.io.Source

object TestFunction {

  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("first class function", 1)

    val primaryFunc = (a: Int, b: Int) => a + b
    println("(a: Int, b: Int) => a + b")
    println(primaryFunc(1, 2))

    case1 endOfCase

    val case2 = Case.createNewCase("high order function", 2)

    // complicated expression in order to show function calculations for folder map
    val totalRevenueFunc = (incomes: List[Int]) => incomes.foldLeft(0)((a, b) => a + b)
    totalRevenueFunc(List(10, 20, 30))

    val untaxMin = 13

    // high order function to calculate taxes
    // high order functions are very useful for lazy calculations
    def taxFunc(calcIncomes: List[Int] => Int, myIncome: List[Int], taxRate: Double) = taxRate match {
      case tax: Double if tax > 0 => calcIncomes(myIncome) * tax
      case _ => 0d
    }

    println(taxFunc(totalRevenueFunc, List(10, 20, 30), 0.2d))

    case2 endOfCase

    val case3 = Case.createNewCase("local functions", 3)

    def processFile(filename: String, width: Int) = {

      //local function to incapsulate special logic for global calculations
      def processLine(filename: String,
                      width: Int, line: String) = {
        if (line.length > width)
          println(filename + ": " + line.trim)
      }


      val source = Source.fromFile(filename)
      for (line <- source.getLines()) {
        processLine(filename, width, line)
      }
    }

    case3.endOfCase

    val case4 = Case.createNewCase("short function syntax", 4)


    val intList = List(10, 2, 5, 8)

    // full size function
    val result1 = intList.filter(x => x > 5)

    // short size function
    val result2 = intList.filter(_ > 5)


    //  another short cut where we have to specify types ambiguous for compiler
    val sum = (_: Int) + (_: Int)

    // but we can write it more consize when we use it in predictable manner

    val simpleCalculate = (a: Int, b: Int, operation: (Int, Int) => Int, processRes: Int => Unit) => processRes(operation(a, b))

    // in this case we see that compiler know about types for executable functional literal _ + _ as its implicated for (Int, Int) => Int
    simpleCalculate(2, 3, _ + _, println(_))

    case4.endOfCase

    val case5 = Case.createNewCase("Partial applied function", 5)

    val calc = (a: Int, b: Int, c: Int) => a + b + c

    val calcPartialAplFunc = calc(1, 2, _: Int)

    calcPartialAplFunc.apply(3)

    case5.endOfCase

    val case6 = Case.createNewCase("Closure", 6)

    def complicatedCalc(a: Int, b: Int) = {

      val i = 0

      def printA() = println(i)

      def printB() = println(b)

      a + b
    }

    case6.endOfCase

    val case7 = Case.createNewCase("Repeated Params", 7)

    /// repteated params work only for def, functions declared as functional literals can't user them

    def echo(args: String*) =
      for (arg <- args) println(arg)

    echo()

    echo("1", "4")
    case7.endOfCase


    val case8 = Case.createNewCase("Named Arguments", 8)

    // this works only with def function
    def  funcTypeParams  (first: Int, second: String) = {

      println(s"first(int) - : $first" )

      println(s"second(String) - : $second" )

    }

    funcTypeParams(second = "b", first = 1)

    case8.endOfCase

    val case9 = Case.createNewCase("Currying", 9)

    val multiPart = (a: Int, b: Int) => a * b

    val curMultiPart = multiPart.curried

    val firstCur = curMultiPart(4)

    val result = firstCur(3)

    println(result)

    println(curMultiPart(3){4})

    case9.endOfCase

    val case10 = Case.createNewCase("new Control Structure", 10)

    def printSmth( file : File)(process: OutputStream => Unit ) ={

      import java.io.FileOutputStream
      val outputStream = new FileOutputStream(file)

      try {
        process(outputStream)
      } catch {
        case ex: Exception => println(ex)
        case _ => println("UnhandledException")
      }
      finally {
        println("finally")
        outputStream.close()
      }
    }

    val uri = this.getClass.getClassLoader.getResource("file.txt").toURI

    val file = Paths.get(uri)
    /// constructing DSL example
    val file1 = file.toFile

    printSmth(file1){ stream =>
      stream.write(new Date().toString.getBytes())
      stream.flush()
    }

    case10.endOfCase




  }
}
