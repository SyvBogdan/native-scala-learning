package com.learning.basics.classes

class Man(val name: String, val age: Int, val gender: String) extends AbstractMan(gender) with Comparable[Man]{
  println("Invoking primary constructor")

  def this(int: Int) = {
    this("Stranger", int, "male")
    println("Invoking auxiliary constructor")
  }

  override def toString = s"Man($name, $age)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Man]

  override def equals(other: Any): Boolean = other match {
    case that: Man =>
      (that canEqual this) &&
        name == that.name &&
        age == that.age
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, age)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def compareTo(o: Man): Int = ???
}
