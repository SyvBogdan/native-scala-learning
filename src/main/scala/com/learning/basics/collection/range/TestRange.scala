package com.learning.basics.collection.range

import com.learning.basics.balancing.RoundRobinStrategy

object TestRange {

  def main(args: Array[String]): Unit = {

    val numConsumers = 20

    //Range(0, numConsumers).foreach(println)

    println(keySerializerClass.getName)

  }


  protected def keySerializerClass = classOf[RoundRobinStrategy]

}
