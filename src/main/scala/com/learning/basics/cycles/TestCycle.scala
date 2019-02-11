package com.learning.basics.cycles

object TestCycle {

  def main(args: Array[String]): Unit = {

    val xVals = 1 to 4
    val yVals = 1 to 2

    val coordinates = for {
      x <- xVals
      y <- yVals

    } yield (x, y)

    println(coordinates)

  }

}
