package com.learning.basics.variance

import com.learning.basics.variance.TestVariance.{Cat, Dog}

import scala._
import scala.collection._

object TestVariance {

  def main(args: Array[String]): Unit = {

    val func1: Cat => Dog = cat => {
      println(cat.getType)
      new Dog
    }

    val func2: Animal => Dog = animal => {
      println(animal.getType)
      new Husky
    }

    val func3: MainCun => Dog = cat => {
      println(cat.getType)
      new Husky
    }

    val animal: Cat = new Cat

    val animal2: Animal = new Cat

    val animal3: Dog = new Dog

    val res1 = execCat(func1, animal)

    val res2: Any =  execCat(func2, animal2)

    //val res3 = execCat(func3, animal)
    //test(animal)
    //test(animal2)
    //test(animal3)
/*    val animals = new mutable.ListBuffer[Any]
    animals.+=(new Object)*/

    val animals: List[Animal] = List[Animal]()
    processAnimal(animals)



  }

  def processAnimal[P >: Animal](list: List[P]): Unit ={

    val f: immutable.List[Any] = list
    println(list)

  }

  def execCat(function1: Function[Cat, Dog], animal: Animal) = function1.apply(new MainCun)

  abstract class Animal {

    def getType: String

  }

  def test(animal: Animal): Dog = ???

  //cats
  class Cat extends Animal {
    override def getType: String = "Cat"
  }

  class MainCun extends Cat {
    def specialVoice = "May"
  }

  //dogs

  class Dog extends Animal {
    override def getType: String = "Dog"
  }

  class Husky extends Dog {
    def voice = "Gov-Gov"
  }

}
