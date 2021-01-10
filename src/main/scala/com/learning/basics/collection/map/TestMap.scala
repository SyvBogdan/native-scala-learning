package com.learning.basics.collection.map

import java.util.concurrent.Executors

import scala.collection.mutable
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object TestMap {

  def main(args: Array[String]): Unit = {

    val map1 = mutable.HashMap(1 -> "1", 2 -> "2", 3 -> "3")

    val executor = Executors.newFixedThreadPool(3)

    //reload
    executor.execute(() => {
      map1.synchronized {
        //get new Data
        println("start1")
        Option(mutable.HashMap(4 -> "4", 5 -> "5", 3 -> "3")) match {
          case Some(data) =>
            println("Start Operation")
            Thread.sleep(1000)
            map1.clear()
            map1 ++= data
        }
        Thread.sleep(4000)
        println(s"map was modified: $map1")
     }
    })

    executor.execute(() => {
      map1.synchronized {
        println("start2")
        //get new Data
        Option(mutable.HashMap(2 -> "8", 8 -> "8", 7 -> "7")) match {
          case Some(data) =>
            println("Start Operation")
            Thread.sleep(1000)
            map1.clear()
            map1 ++= data
        }
        Thread.sleep(4000)
        println(s"map was modified: $map1")
      }
    })


    Thread.sleep(800)
   // println(map1.get(1))

  }
}
