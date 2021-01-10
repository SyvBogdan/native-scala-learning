package com.learning.basics.arrays

object TestArrays {

  def main(args: Array[String]): Unit = {

    //https://www.scala-lang.org/api/2.12.6/scala/Array.html


    val numbers = Array(1, 2, 3, 4)
    val first = numbers(0) // read the first element
    numbers(3) = 100 // replace the 4th array element with 100
    val biggerNumbers = numbers.map(_ * 2) // multiply all numbers by two

    ///println(numbers(1))


    //val arr: Array[Int] = Array(1, 2, 3)
   // val seqReversed: Seq[Int] = arr.reverse

    //val newSeq = seqReversed :+ 4


    /// iteration through arrays

    for (elem <- numbers if elem < 100) println(elem)


    val template = "User %s is not authorized to create any events in broker %s"

    val broker = "kafka"

    val eventId = 101

//    println(bind(template, broker, eventId))

    val d = null

    println(Some(d))

    println()

  }


  def someFunc() = null
  val broker = "kafka"

  val eventId = 101


  private def bind(template: String, args: Any*): String ={
    println(args.toArray)
    template.format(args.toList)
  }

}
