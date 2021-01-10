package com.learning.basics.monade.either

object TestEither {

  def main(args: Array[String]): Unit = {

    val input = 1

    val eitherResult: Int => Either[String, String] = (in: Int) =>
      if (in % 2 == 0) Left("even") else Right("odd")


   val res =
     for{
      // x <- Option(1)
       res <- eitherResult(input)
     }
      yield { res + 1}

    println(res)

  }

}
