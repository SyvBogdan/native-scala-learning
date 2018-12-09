package com.learning.basics.exception

case class ZeroDivideException(message: String) extends RuntimeException(message)
