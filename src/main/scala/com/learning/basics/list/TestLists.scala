package com.learning.basics.list

object TestLists {

  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3)

    val list2 = List(4, 5, 6)


    ////  List(1,2) :: 3 = new List( 3 and List(1,2) as reference  ) :: Nil
    ////  List(1,2,3) :: 4  =  new List(4 and List( 3 and List(1,2) as reference) as reference ) :: Nil

    val anotherList = 10 :: list

    val appendedList = anotherList :+ 20

    val newList = 6 :: 7 :: 8 :: Nil


    ///head
    val head = list.head
    println(head)

    //tail
    val tail = list.tail
    println(tail)

    // init

    val init = list.init


    //reverse find last elem
    val last1 = list.last //O(n)
    val last2 = list.reverse.head // O(n)
    val last3 = list.apply(list.size - 1) // O(1)

    //// updating and patching
    val newUpdatedList = list.patch(1, Seq(100), 1)

    val aonotherUpdatedList = newUpdatedList.updated(1, 200)


    println(last1)
    println(last2)
    println(last3)

  }
}
