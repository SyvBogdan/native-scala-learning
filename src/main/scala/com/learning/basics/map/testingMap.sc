

val map = Map( 1 -> "1", 2 -> "2")

map.foreach( tuple => println( s"${tuple._1}  ${tuple._2}"))
//map.foreach(println(_))


val arr = Array(1, 2, 3)
val arrReversed = arr.reverse
val seqReversed: Seq[Int] = arr.reverse




val concat = (list1: List[String], list2: List[String]) => List[java.io.Serializable] = list1::list2