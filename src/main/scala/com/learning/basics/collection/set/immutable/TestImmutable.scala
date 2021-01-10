package com.learning.basics.collection.set.immutable

object TestImmutable {

  def main(args: Array[String]): Unit = {

   val seq = Seq.empty[String]

    println(processCollect(seq))
  }


  def processCollect(seq: Seq[String]): Boolean =
     seq map (d => true) find(_ == true) match {
      case Some(r) => r
      case _ => false
    }

}
