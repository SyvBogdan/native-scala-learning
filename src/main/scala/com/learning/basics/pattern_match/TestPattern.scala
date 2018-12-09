package com.learning.basics.pattern_match

import com.learning.basics.helper.Case


object TestPattern {

  def main(args: Array[String]): Unit = {

    /// general approach to declare Pattern matching is through such construction:
    //  selector match { alternatives ... }

    //case 1

    val case1 = Case.createNewCase("Simple Pattern mathing", 1)

/*    val shape = new Shape {
      override val area: Int = 0
    }*/

    val simplePattern = (any: AnyRef) =>
      any match {
        case figure: Shape => "This is shape with area:" + figure.area
        case _ => "the object is not the figure"
      }

    println(simplePattern(Circle(3)))
    case1.endOfCase

    //case 2

    val case2 = Case.createNewCase("Wild Card Pattern", 2)

    val wildCardPattern = (any: Any) => any match {
      case circle: Circle => s"Circle With radius ${circle.r} "
      case _ => "the figure is not the Circle"
    }
    println(wildCardPattern(Circle(3)))
    case2.endOfCase

    //case 3

    val case3 = Case.createNewCase("Constant patterns", 3)

    val totalPattern = (any: Any) => any match {
      case cc: Circle2.type => "Circle2 singleton object"
      case tp: TestPattern.type => "main singleton object"
      case shape: Circle => s"Circle With area ${shape.area} "
      case square: Square => s"Square with area ${square.area}  "
      case Nil => "the empty list"
      case _ => "something else"
    }

    println(totalPattern(TestPattern))
    case3.endOfCase

    //case 4

    val case4 = Case.createNewCase("Constant patterns", 4)

    val variablePattern = (any: Any) =>
      any match {
        case 0 => "zero"
        case somethingElse => "list string"

      }

    println(variablePattern(List("a")))

    case4.endOfCase

    //case 5
    val case5 = Case.createNewCase("Constructor patterns", 5)

    val constructorPattern = (any: Shape) =>
      any match {
        case Rectangle(5, a) => s"This is Rectangle with side length: 5, and default width"
        case Square(a) => s"This is Square with side a: $a"
        case Circle(8) => "This is Circle with radius 8 "
        case somethingElse => "somethingElse"
      }

    println(constructorPattern(Rectangle(5, 40)))
    println(constructorPattern(Circle(8)))

    case5.endOfCase

    //case 6
    val case6 = Case.createNewCase("Sequence patterns", 6)

    val sequencePattern = (any: Any) =>
      any match {

        case List(_*) => "List with default params"
        case somethingElse => "somethingElse"
      }

    println(sequencePattern(Nil))
    println(sequencePattern(List()))
    println(sequencePattern(List(4, 6, 7, 8)))

    case6.endOfCase

    //case 7
    val case7 = Case.createNewCase("Tuple patterns", 7)

    val tpl: Tuple3[Int, String, Any] = (1, "a", new AnyRef)

    val num = tpl._1
    val str = tpl._2

    val tuplePattern = (any: Any) =>
      any match {
        case (a, _, _) => s"Tuple with 3 params, with first param $a"
        case somethingElse => "somethingElse"
      }

    println(tuplePattern(tpl))

    case7.endOfCase

    //case 8
    val case8 = Case.createNewCase("Typed patterns", 8)

    val typedPattern = (any: Any) =>

      any match {
        case str: String => s"This is string"
        case map: Map[_, _] => "This is map"
        case circle2: Circle2 => "This is circle2"
        case _ =>
      }

    println(typedPattern("str"))
    println(typedPattern(Map(1 -> "1", 2 -> "2")))

    case8.endOfCase

    //case 9
    val case9 = Case.createNewCase("Variable bind patterns", 9)

    val variableBindingPattern = (any: Any) =>
      any match {
        case Rectangle(8, a@_) => s"Rectangle w with first param $a"
        case somethingElse => "somethingElse"
      }

    println(variableBindingPattern(Rectangle(8, 9)))

    case9.endOfCase

    //case 10
    val case10 = Case.createNewCase("Patterns guards", 10)

    val patternGuard = (any: Any) =>
      any match {
        case Rectangle(x@1, y) if x == y => s"This Rectangle is Square with side $x"

        //case somethingElse => "somethingElse"
      }

    println(patternGuard(Rectangle(1, 1)))
    case10.endOfCase

    //case 11
    val case11 = Case.createNewCase("Sealed classes in pattern and unchecked annotation", 11)

    val sealedPattern = (any: Any @unchecked) =>
      any match {
        case Rectangle(x, y) if x == y => s"This Rectangle is Square with side $x"
        //  case somethingElse => "somethingElse"
      }

    println(sealedPattern(Rectangle(2, 2)))
    case11.endOfCase


  }
}
