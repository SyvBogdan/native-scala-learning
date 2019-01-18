package com.learning.basics.traits

import com.learning.basics.helper.Case

object TestTraits {

  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("Trait exploration", 1)

    val teamLead: TeamLead = new TeamLead

    val man: Man = teamLead

    // and types that are mix in to TeamLead class
    val developer: Developer = teamLead

    val learning: Learning = teamLead

    case1.endOfCase

    val case2 = Case.createNewCase("Dynamic trait bynding", 2)

    val dynamicTrait: DynamicTrait = new Man with DynamicTrait

    val dynamicTraitWithProp: DynamicTraitWithProp = new Man with DynamicTraitWithProp {

      override val prop: String = "ddddd"

      override def showProperty: String = prop

    }
    println(dynamicTraitWithProp.showProperty)

    case2.endOfCase

    val case3 = Case.createNewCase(" trait with already mix in existing method from another Trait", 3)

    trait  SimpleTrait {
      def whoAmI() = println("I am SimpleTrait")
    }

    trait  SimpleTrait2  {
      def whoAmI() = println("I am SimpleTrait2")
    }

   /* class CompoundTrait extends SimpleTrait with SimpleTrait2 -- compilation error due to dublication */

   /* class SimpleClass extends CompoundTrait {
     // override def whoAmI() = println("I am SimpleClass")
    } -- compilation error due to dublication  */


  }
}
