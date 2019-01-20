package com.learning.basics.packages

import outerpackage.inner1.innerInner.TestClass
import outerpackage.inner2.TestClass2

object TestPackages {

  def main(args: Array[String]): Unit = {

    val testClass = new TestClass
    println(testClass.getClass.getName)

    val testClass2 = new TestClass2
    println(testClass2.getClass.getName)

  }
}
