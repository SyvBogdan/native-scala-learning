package com.learning.basics.function

import com.learning.basics.helper.Case

object TestFunction {

  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("first class function", 1)

    val primaryFunc = (a: Int, b: Int) => a + b
    println("(a: Int, b: Int) => a + b")
    println(primaryFunc(1, 2))

    case1 endOfCase

    val case2 = Case.createNewCase("high order function", 2)

    // complicated expression in order to show function calculations for folder map
    val totalRevenueFunc = (incomes: List[Int]) => incomes.foldLeft(0)((a, b) => a + b)
    totalRevenueFunc(List(10, 20, 30))

    val untaxMin = 13

    // high order function to calculate taxes
    // high order functions are very useful for lazy calculations
    def taxFunc(calcIncomes: List[Int] => Int, myIncome: List[Int], taxRate: Double) = taxRate match {
      case tax: Double if tax > 0 => calcIncomes(myIncome) * tax
      case _ => 0d
    }

    println(taxFunc(totalRevenueFunc, List(10, 20, 30), 0.2d))

    case2 endOfCase

  }
}
