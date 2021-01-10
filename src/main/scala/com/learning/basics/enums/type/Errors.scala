package com.learning.basics.enums.`type`

import com.learning.basics.ErrorType

object Errors extends Enumeration {

  val Unknown: ErrorType = Value(1001, "Internal server error")
  val InternalError: ErrorType = Value(1002, "Internal server error")
  val ResourceNotFound: ErrorType = Value(1003, "Current resource not found")

}
