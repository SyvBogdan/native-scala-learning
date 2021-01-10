package com.learning.basics.binary

object TestBinary {

  def main(args: Array[String]): Unit = {

    val sum = 5

    val checkSum = sum & 0xFF

    println(checkSum)

    val inverse = ~sum & 0xFF

    println(inverse)

  }

}
