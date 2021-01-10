package com.learning.basics.implicits

import java.util.concurrent.Executors

import scala.concurrent.ExecutionContext

object TestImplicit {

  def main(args: Array[String]): Unit = {

    20.whoIam()

  }

  implicit val ec = ExecutionContext.fromExecutorService(Executors.newCachedThreadPool())

  implicit class IntInt1(val int: Int) {

    def whoIam() = println("IntInt1: " + int)
  }

  implicit class RichLong2(val int: Long) {

    def whoIam() = println("RichLong2: " + int)
  }

}


