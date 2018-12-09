package com.learning.basics.pattern_match

case class Circle2(radius: Double) {
  import Circle2._
  def area: Double = calculateArea(radius)
}

object Circle2 {
   def calculateArea(radius: Double): Double = Math.PI * Math.pow(radius, 2.0)
}