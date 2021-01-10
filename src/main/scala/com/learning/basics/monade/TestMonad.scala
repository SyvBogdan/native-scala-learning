package com.learning.basics.monade

import com.learning.basics.Basics
import com.learning.basics.helper.Case
import javax.swing.JComponent

import concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object TestMonad {
  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("Option map ", 1)

    val result = null.asInstanceOf[String]

/*    val res = Option{result}
      .flatMap(e => "Is not empty")
      .orElse(Option{"Is empty"})

    println(res.get)*/

    case1.endOfCase

    val case2 = Case.createNewCase("Option fold, flatMap {bind}, getOrElse, orNull", 2)

    val option: Option[Int] = None

    val foldResult: Int =  option.fold(null.asInstanceOf[Int])(_ * 100)
    println(s"foldResult: $foldResult")

    val getOrElseResult: Int = option.getOrElse(100)
    println(s"getOrElseResult: $getOrElseResult")

    val flatMapResult: Int = option.flatMap(d => Option(d.toString)).fold(0)(f =>{10})
    println(s"flatMapResult: $flatMapResult")

   // val orNullResult = option.orNull
    //println(s"orNullResult: $orNullResult")

    val initialText: Option[Integer] = Some(2)
    val textField = new SomeClass(initialText.orNull,20)

  }

  class SomeClass(str: Integer, i: Int)

}
