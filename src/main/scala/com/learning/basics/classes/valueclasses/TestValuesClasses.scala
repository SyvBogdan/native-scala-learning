package com.learning.basics.classes.valueclasses

object TestValuesClasses {

  def main(args: Array[String]): Unit = {

    // implicit def extendInt(i: Int) = new ExtendedInt(i)
    val n: Int = 1
    Nil
    n plus12345 2
  }

  implicit class DDDd(val value: Int)  {
    def plus12345(other: Int) = value + other
  }
}
