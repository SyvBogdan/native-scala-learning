package com.learning.basics.manifest

import scala.reflect.ClassTag

object TestManifest {

  def main(args: Array[String]): Unit = {


   var buffer =  arrBuffer[String] += "one"

    println(buffer)
  }


  def arrBuffer[T]/*(implicit m: ClassTag[T])*/ = collection.mutable.ArrayBuffer[T]()
}
