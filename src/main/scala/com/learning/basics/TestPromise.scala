package com.learning.basics

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
object TestPromise extends  App {

  val promise = Promise[Boolean]()

  val kafkaListenerEmulator =Future{
    println("Processing")
    Thread.sleep(100)
  //  throw  new RuntimeException("ffff")
    println("done")
    true
  }.onComplete{
    case Success(value) => promise success value

    case Failure(ex) => promise success false
  }

  println(Await.result(promise.future, Duration.Inf ))
}
