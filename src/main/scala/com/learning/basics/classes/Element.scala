package com.learning.basics.classes

abstract class Element {
  println("Element is init")
  def contents: Array[String]
  val height = contents.length
  val width =
    if (height == 0) 0 else contents(0).length

  def canEqual(other: Any): Boolean = other.isInstanceOf[Element]

  override def equals(other: Any): Boolean = other match {
    case that: Element =>
      (that canEqual this) &&
        height == that.height &&
        width == that.width
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(height, width)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
