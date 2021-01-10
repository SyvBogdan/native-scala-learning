package com.learning

import com.learning.basics.enums.`type`.Errors

package object basics {

  type ErrorType = Errors.Value

  implicit class ValDef(error: ErrorType){

    def errorId: Int = error.id
    def errorMessage: String = error.toString
  }

}
