package com.learning.basics.future

import scala.concurrent.{Await, Future}
import concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}



object TestFuture {

  def main(args: Array[String]): Unit = {

    val start = System.currentTimeMillis()

    val fs = (1 to 30).grouped(2).map { x =>
      Future {
        val ts = System.currentTimeMillis() - start
        Thread.sleep(100)
        (x.head, x.head + x.length - 1, ts)
      }
    }

    val res = Future.sequence(fs)


   // Await.result(res, Duration.Inf).foreach(
   //   println
   // )


    val divideFuture = Future {

      val f = 5 / 0
    }.onComplete {

      case Success(value) => println(value)
      case Failure(exception) => println(exception)
    }

    Thread.sleep(10000)
  }
}
