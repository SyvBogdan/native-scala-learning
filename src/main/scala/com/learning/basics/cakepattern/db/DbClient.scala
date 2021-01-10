package com.learning.basics.cakepattern.db

trait DbClient {

 def getInfo: Int

 def saveInfo(intVal: Int):Unit



}
