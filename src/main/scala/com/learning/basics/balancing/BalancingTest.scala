package com.learning.basics.balancing

object BalancingTest {

  def main(args: Array[String]): Unit = {


    val strategy = new RoundRobinStrategy

    while (true){

      println( strategy.getNext)
      Thread.sleep(100)
    }


  }

}
