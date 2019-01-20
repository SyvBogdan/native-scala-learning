package com.learning.basics.traits

trait Developer {

  this: DynamicTrait =>
  // common property as in java field
  val level: String

  def develop () = s"I am developing with level ${level}"
}
