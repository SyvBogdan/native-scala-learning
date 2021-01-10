package com.learning.basics.classes.valueclasses

object TestValuesClasses {

  def main(args: Array[String]): Unit = {

    // implicit def extendInt(i: Int) = new ExtendedInt(i)
    val n: Int = 1
    Nil
    n plus12345 2

    import MyPredef._
    //imported implicits come into effect within this scope

    import java.math.BigInteger
    implicit def Int2BigIntegerConvert(value: Int): BigInteger =
      new BigInteger(value.toString)

    def add(a: BigInteger, b: BigInteger) = a.add(b)

    println(add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9) )
    println(add(3, 6) == 9)


    val s = Seq("hello", "world")
    val r: Seq[String] = s map {
      _.reverse
    }

    println(r)

    val xs = List("Manny", "Moe", "Jack")
    val ys = List("Manny", "Moe", "Jack")
    println(xs sameElements ys)


    val xt = List("Manny", "Moe", "Jack")
    val yt = List("Manny", "Jack", "Moe")
    println(xt sameElements yt)

    val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
    val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
    //println(xs1 sameElements ys1)

    val xt1 = Set(1, 2, 3)
    val yt1 = Set(3, 2, 1)
  //  println(xt1 sameElements yt1)

  }

  implicit class DDDd(val value: Int)  {
    def plus12345(other: Int) = value + other
  }

  object MyPredef {

    class KoanIntWrapper(val original: Int) {
      def isOdd = original % 2 != 0

      def isEven = !isOdd


    }

    implicit def thisMethodNameIsIrrelevant(value: Int) =
      new KoanIntWrapper(value)
  }

}
