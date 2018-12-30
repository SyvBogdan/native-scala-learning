package com.learning.basics.monade

import com.learning.basics.Basics
import com.learning.basics.helper.Case

object TestMonad {
  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("Option map ", 1)

    val result = null.asInstanceOf[String]

    val res = Option{result}
      .map(e => "Is not empty")
      .orElse(Option{"Is empty"})

    println(res.get)

    case1.endOfCase
  }


}
