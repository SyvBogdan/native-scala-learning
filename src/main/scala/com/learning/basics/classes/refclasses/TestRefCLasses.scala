package com.learning.basics.classes.refclasses

import com.learning.basics.classes.{CompleteElement, Element}
import com.learning.basics.helper.Case

object TestRefCLasses {

  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("Null as the bottom of hierarchy of Ref objects", 1)

    var obj: Null = null

    var obj2 = new CompleteElement()
    // int = 10
    obj2 = obj
    var number : Int = 2
    //number = obj  - compilation failed because of Null is not sub class of anyVal types

    println(obj2)

    case1.endOfCase

    val case2 = Case.createNewCase("How to compare to methods", 2)

    val element = new CompleteElement

    val element2 = new CompleteElement

    println(element == element2)  // In Scala returns true as method  '==' implication of equals as in Java works

    println(element.equals(element2))  //  Also we can use traditional  Java methods equals instead of previous one
    // and we will get the same result

    //but  if we want to compare to Ref we have to use 'eq' method form one of the comparable AnyRef
    println(element.eq(element2)) // returns false because of different refs

    case2.endOfCase
  }

}
