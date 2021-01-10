package com.learning.basics.collection.list

import scala.collection.immutable
import scala.collection.immutable.{HashSet, TreeSet}

object TestList {

  def main(args: Array[String]): Unit = {

    val integers: List[Integer] = List(1, 2, 3)

    val d: immutable.Seq[Number] = test(integers)

    println(d.foldLeft(" ")((prev, next) => prev + " " + next))

    val lines = List("a", "b", "c", "d")


    val processedLines = lines.foldLeft(0)((counter, nextLine) ⇒ {
      writeLine(nextLine)
      counter + 1
    })

    println(processedLines)


    val listForParts = Array(4, 2, 1, 3, 0, 5, 6)

    val parts = listForParts.groupBy(el ⇒ if (el > 3 && el<5) "large" else "small")

    println(parts)

  }

  def test(set: List[Number]) = {

    val newColl: List[Number] = 1.0f :: set

    newColl
  }

  def writeLine(line: String) = {}
}
