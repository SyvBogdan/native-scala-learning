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

      this: SimpleTrait2 =>
      def whoAmI() = println("I am SimpleTrait2")
    }

   /* class CompoundTrait extends SimpleTrait with SimpleTrait2 -- compilation error due to dublication */

   /* class SimpleClass extends CompoundTrait {
     // override def whoAmI() = println("I am SimpleClass")
    } -- compilation error due to dublication  */
    case3.endOfCase

    val case4 = Case.createNewCase("self types in  traits", 3)

    trait User {
      def username: String
    }

    trait Tweeter {
      this: User =>  // reassign this
      def tweet(tweetText: String) = println(s"$username: $tweetText")
    }

    class VerifiedTweeter(val username_ : String) extends Tweeter with User {  // We mixin User because Tweeter required it
      def username = s"real $username_"
    }

    val realBeyoncé = new VerifiedTweeter("Beyoncé")
    realBeyoncé.tweet("Just spilled my glass of lemonade")
    ///////////////////////////////////////////////////////////////

    trait ReaderWriter{
      def read(): String = "data from file"
      def write(): String = "data written to file"
    }

    trait ReaderWriterDB extends ReaderWriter{
      override def read(): String = "data from DB"
      override def write(): String = "data written to DB"
    }

    class Service{
      this: ReaderWriter =>
      def reading: String = read()
      def writing : String = write()
    }

    val servise = new Service with ReaderWriter

    println(servise.reading)
    println(servise.writing)

    val servise2 = new Service with ReaderWriterDB

    println(servise2.reading)
    println(servise2.writing)

    case4.endOfCase

  }
}
