package com.learning.basics.classes

abstract class Element {
  println("Element is init")
  def contents: Array[String]
  val height = contents.length
  val width =
    if (height == 0) 0 else contents(0).length
}
