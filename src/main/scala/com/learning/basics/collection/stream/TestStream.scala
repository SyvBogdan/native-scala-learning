package com.learning.basics.collection.stream


import java.util

object TestStream {

  def main(args: Array[String]): Unit = {

    lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

    val simpleStream: Stream[Int] = 1 #:: 2 #:: 3 #:: Stream.empty[Int]

    println(simpleStream)

    def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)

    fibFrom(1,1) take 10 foreach println

  //  val javaSeq = util.Set

  }
}
