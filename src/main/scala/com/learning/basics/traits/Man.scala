package com.learning.basics.traits

//
class Man extends Developer with DynamicTrait {

  override lazy val level: String = "Senior"

  override def develop(): String = super.develop()
  // we can't override final method from trait even in subclass
  //override def learnSmth(subject: String): String = super.learnSmth(subject)

  // def showProperty : String = level
}
