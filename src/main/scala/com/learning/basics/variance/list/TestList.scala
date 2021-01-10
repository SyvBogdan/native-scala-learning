package com.learning.basics.variance.list

object TestList {

  def main(args: Array[String]): Unit = {


  }


  class Test[+A] {
    def testset[U >: A](el: U) ={}
  }

  trait Node[B] {
    def prepend(elem: B): Node[B]
  }

  /* case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
     def prepend(elem: B): ListNode[B] = ListNode(elem, this)
     def head: B = h
     def tail: Node[B] = t
   }

   case class Nil[+B]() extends Node[B] {
     def prepend(elem: B): ListNode[B] = ListNode(elem, this)
   }*/

}
