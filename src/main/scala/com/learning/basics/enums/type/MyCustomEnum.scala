package com.learning.basics.enums.`type`


object MyCustomEnum extends Enumeration {

  val A: MyVal = Value( 1, "x", "y")

  class MyVal(id: Int, x: String, val y : String) extends Val(id, x)

  protected final def Value(id: Int, name: String, x : String): MyVal = new MyVal(id ,name, x)
}
