package com.learning.basics.monade.try_monade

import java.util.Random

import com.learning.basics.helper.Case

import scala.util.{Failure, Success, Try}

object TryMonadeTest {

  def main(args: Array[String]): Unit = {


    var count = 0

    val tryObject = Try({
      println("count: " + count)
      if (count % 2 == 1) {
        println("dddddddd")

        RandomObject.create
      } else {
        throw new RuntimeException("error")
      }
    })

    tryObject match {
      case Success(value) => println(value.rand)
      case Failure(ex) => println(ex)
    }

    println("incremrnt")
    count = count + 1

    tryObject match {
      case Success(value) => println(value.rand)
      case Failure(ex) => println(ex)
    }

    tryObject match {
      case Success(value) => println(value.rand)
      case Failure(ex) => println(ex)
    }


    val case1 = Case.createNewCase("Test try monde", 1)

    val d = Try {
      doSmthWrong()
    } andFinally {
      println("postAction")} match {
      case Success(value) ⇒ println(value)
      case Failure(ex) ⇒ println(ex)
    }
    case1.endOfCase

  }

  def doSmth() = {
    println("process")
    Thread.sleep(3000)

    "success"
  }

  def doSmthWrong(): String = {
    println("processWrong")
    Thread.sleep(3000)
    throw new RuntimeException("processWrong")
  }

  class RandomObject {

    val rand = new Random().nextInt()

  }


  object RandomObject {

    def create: RandomObject = new RandomObject()

  }

  implicit class AfterTryResult[V](tryContainer: Try[V]) {

    def andFinally(afterTryAction: ⇒ Unit): Try[V] = {
      afterTryAction
      tryContainer
    }
  }


  val calculate = Try(0/0)

  val resultSquare: Int ⇒ Try[Int] = (res: Int) ⇒ Try(res * 2)

 /* calculate.flatMap(resultSquare) match {
    case Success(value) ⇒
      println(value)
    case Failure(ex) ⇒
      println(ex)
  }*/



    val d = trySmth("test1")
    .filter(!_.equals("test1"))


  d match {
    case Success(value) =>
      println(value)
    case Failure(exception) =>
      println(exception)
  }

  def trySmth(path: String ) = Try{
    if (!path.isEmpty) path else throw new RuntimeException("Fail1")
  }



}
