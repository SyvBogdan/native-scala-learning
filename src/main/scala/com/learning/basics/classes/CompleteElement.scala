package com.learning.basics.classes

import scala.util.Random

class CompleteElement extends Element {
  println("CompleteElement is init")
  override lazy val contents: Array[String] = {
    println("contents is calculated")
    Array("1","2","3")}

  val test = (int: Int) => int * 2

}
