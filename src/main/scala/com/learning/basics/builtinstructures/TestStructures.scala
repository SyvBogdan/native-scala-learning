package com.learning.basics.builtinstructures

import scala.util.Random

object TestStructures {

  def main(args: Array[String]): Unit = {


    println(testIf(1))

    val forResult: Seq[Int] = testFor(20)

    testTableMultiplication()
  }

  def testIf(int: Int) = if (int > 0) int * 20


  def testFor(int: Int) = {

    for {i <- 0 to int
         if i % 2 == 0
         if i > 10
    }
      yield {
        //  val c = new Random()
        //  c.nextInt() *  i
        i
      }


  }

  def testTableMultiplication() =
    for {i <- 0 to 9
         if i % 2 == 0
         j <- i to 9
    } {
      println(s" $i * $j = ${i * j} \n")
    }

}
