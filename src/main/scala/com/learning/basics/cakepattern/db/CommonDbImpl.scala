package com.learning.basics.cakepattern.db

trait CommonDbImpl extends DbClient {

  override def getInfo: Int = ???

  override def saveInfo(intVal: Int): Unit = ???
}
