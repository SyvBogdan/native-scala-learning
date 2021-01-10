package com.learning.basics.variance

object BoundsType {


  def main(args: Array[String]): Unit = {


    val dogContainer = new PetContainer[Dog]
    val catContainer = new PetContainer[Cat]

    val res: Smth = getAnimal[Smth](classOf[Smth])
  }

  def getAnimal[T <: Smth](clazz: Class[T]): T = {

    val t: T = doSmth("", clazz )

    t
  }

  def doSmth[I](i: String, clazz: Class[I]): I = null.asInstanceOf[I]


  abstract class Animal {
    def name: String
  }


  case class Smth(id: String)


  abstract class Pet extends Animal {}

  class Cat extends Pet {
    override def name: String = "Cat"
  }

  class Dog extends Pet {
    override def name: String = "Dog"
  }

  class Lion extends Animal {
    override def name: String = "Lion"
  }

  class PetContainer[P <: Pet] {
    def setpet(e: P) = ???
  }

}
