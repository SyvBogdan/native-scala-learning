package com.learning.basics.monade.option

import java.net.InetSocketAddress

object TestOption {

  def main(args: Array[String]): Unit = {

/*    def makeUpper(xs: List[String]) = xs map {
      _.toUpperCase
    }

    def makeWhatEverYouLike(xs: List[String], sideEffect: String ⇒ String) =
      xs map sideEffect

    println(makeUpper(List("abc", "xyz", "123")))

    println(makeWhatEverYouLike(List("ABC", "XYZ", "123"), { x ⇒
      x.toLowerCase
    }))


    val myName = (name: String) => s"My name is $name"
println(makeWhatEverYouLike(List("John", "Mark"), myName))

    println(List("Scala", "Erlang", "Clojure") map (_.length))

    val a = List(1, 3, 5, 7)
   println(a.reduceLeft(_ + _))*/


    val option = Some(4)

    println(option.head)

    option map(_=> 5)

    println(option.head)


    def findPort(): Option[Int] = None//Some(22)

    def findHost(): Option[String] = None//Some("my.host.com")

    val address: Option[InetSocketAddress] = for {
      host <- findHost()
      port <- findPort()
    } yield new InetSocketAddress(host, port)

    println(address)
  }
}
