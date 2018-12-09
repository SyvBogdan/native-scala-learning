package com.learning.basics.pattern_match

sealed abstract class Shape {
   val area: Int
}

case class Rectangle(a: Int, b: Int) extends Shape {
  override val area: Int = a * b
}

case class Circle(r: Int) extends Shape {
  override val area: Int = (Math.PI * Math.pow(r, 2)).toInt
}

case class Square(side: Int) extends Shape {
  override val area: Int = Math.pow(side, 2).toInt
}


