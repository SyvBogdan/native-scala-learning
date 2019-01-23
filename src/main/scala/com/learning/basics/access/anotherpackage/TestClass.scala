package com.learning.basics.access.anotherpackage

// primary cons
class TestClass(val paramInt: Int, val paramString: String, val paramChar: Char) {
  // primary constructor body
  println("Primary Constructor is invoked")

  private val secretPwd = "123"

  // package access configuration
  private[access] val partlyVisibleVar = "ddddd"

  // instanse access configuration (decline visibility for companion object)
  private[this] val fullyInvisibleParam = "ssssss"

  //TestClass.someVarInsideObject - wil not compile as restricted by object scope protection

  private def this(paramInt: Int, string: String) {
    // primary constructor must be invoked in any case
    this(paramInt, string, Char.MaxValue)
    println("Secondary Constructor is invoked")
  }

  def this(paramInt: Int) {
    this(paramInt, "default", Char.MaxValue)
    println("Secondary Constructor is invoked")
  }

  object SimpleObject {

    def whoami = this.getClass.getName + s" with secrectPwd${secretPwd}"
  }

  protected def primaryMethod() = "primary method"

}

object TestClass {
  println("Primary object Constructor is invoked")

  //visible in scope of object only
  private [this] val someVarInsideObject = "qqqqqqq"

  // private constructor can be invoked
  def createTestClass: TestClass = {
    val testClass = new TestClass(1, "sdf")
    println(testClass.secretPwd)

    //println(testClass.fullyInvisibleParam) - failed to see
    testClass
  }
}

///// Test2Class with companion
class Test2Class(val paramInt1: Int, val paramString1: String, val paramChar1: Char)
  extends TestClass(paramInt1, paramString1, paramChar1) {


  super.primaryMethod()

  private def secretMethod() = "ddddddddd"
}


class Test3Class(val paramInt1: Int, val paramString1: String, val paramChar1: Char)
  extends TestClass(paramInt1, paramString1, paramChar1) {

  super.primaryMethod()

  private def secretMethod() = "ddddddddd"
}


object Test2Class {
  println("Primary object Constructor is invoked")

  // private constructor can be invoked
  def createTest2Class: Test2Class = {
    val test2Class = new Test2Class(1, "sdf", Char.MaxValue)
    println(test2Class.secretMethod())
    test2Class
  }

}
