package strings

import com.learning.basics.helper.Case

object TestStrings {

  val MOD_ADLER = 65521
  def main(args: Array[String]) = {
    val sum = adler32sum("Wikipedia")
    printf("checksum (int) = %d\n", sum)
    printf("checksum (hex) = %s\n", sum.toHexString)

    println(75523%MOD_ADLER)

    val case1 = Case.createNewCase("Test regular patterns", 1)

    val MoviesZipRE = "movies (\\d{5})".r
    val MoviesNearCityStateRE = "movies near ([a-z]+), ([a-z]{2})".r

    "movies near boulder, co" match {
      case MoviesZipRE(zip) => println(zip)
      case MoviesNearCityStateRE(city, state) => println(s"$city, $state")
      case _ => println("did not match a regex")
    }

    case1.endOfCase


  }
  def adler32sum(s: String): Int = {
    var a = 1
    var b = 0
    s.getBytes.foreach{char =>
      a = (char + a) % MOD_ADLER
      b = (b + a) % MOD_ADLER
    }
    // note: Int is 32 bits, which this requires
    b * 65536 + a // or (b << 16) + a
  }

}
