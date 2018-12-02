package com.learning.basics.arrays

object TestArrays {

  def main(args: Array[String]): Unit = {

    //https://www.scala-lang.org/api/2.12.6/scala/Array.html


    val numbers = Array(1, 2, 3, 4)
    val first = numbers(0) // read the first element
    numbers(3) = 100 // replace the 4th array element with 100
    val biggerNumbers = numbers.map(_ * 2) // multiply all numbers by two

    println(numbers(1))


    val arr = Array(1, 2, 3)
    val arrReversed = arr.reverse
    val seqReversed : Seq[Int] = arr.reverse

    println(seqReversed)

  }
}
