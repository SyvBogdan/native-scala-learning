package com.learning.basics.helper

trait Case {
  def endOfCase: Unit
}

object Case {

    private class ImplCase(val caseName: String, val num: Int) extends Case {

    val header = "********************" + "Case: " + num + ", " + caseName + "***************************"
    println(header)
    println(makeRelevantLength('*', header))

    def endOfCase: Unit ={
      val end = "End of Case " + num
      println(makeStarLine('*', header.length / 2 - end.length) + end + makeStarLine('*', header.length / 2))
    }
  }

  def createNewCase(name: String, num: Int): Case = {
    new ImplCase(name, num)
  }

  private val makeRelevantLength = (char: Char, word: String) => {
    for (s <- word) yield char
  }
  private val makeStarLine =  (char: Char, quantity: Int) => (for (i <- 1 to quantity) yield char).mkString

}


