package com.learning.basics.enums

import com.learning.basics.ErrorType
import com.learning.basics.enums.`type`.Errors.InternalError
import com.learning.basics.enums.`type`.{Errors, MyCustomEnum}
import com.learning.basics.helper.Case

object TestEnums {

  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("implicit method for enum: errorId and errorMessage", 1)

    val errorType: ErrorType = InternalError

    println(s"errorId: ${errorType.errorId}, errorMessage: ${errorType.errorMessage}")

    case1.endOfCase



    val case2 = Case.createNewCase("implicit method for enum: errorId and errorMessage", 1)

    val myCustomEnum = MyCustomEnum.A

    println(s"Custom enum params: id: ${myCustomEnum.id}, name: ${myCustomEnum.toString}, y: ${myCustomEnum.y}")

    case2.endOfCase
  }

}
