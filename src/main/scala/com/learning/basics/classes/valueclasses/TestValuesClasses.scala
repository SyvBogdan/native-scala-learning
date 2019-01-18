package com.learning.basics.classes.valueclasses

object TestValuesClasses {

  def main(args: Array[String]): Unit = {

    // implicit def extendInt(i: Int) = new ExtendedInt(i)
    val n: Int = 1

    n.plus1(2)
  }

  implicit class ExtendedInt2(val value: Int) extends AnyVal {
    def plus1(other: Int) = value + other
  }
}
