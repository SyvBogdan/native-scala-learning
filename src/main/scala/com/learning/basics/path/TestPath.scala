package com.learning.basics.path

import java.io.File
import java.nio.file.Files

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

object TestPath {

  def main(args: Array[String]): Unit = {

    val expectedDir = "D:/scala/test3/test2"

/*    createPath(expectedDir) match {
      case Success(dir) ⇒ println(s"directory: ${dir.getAbsolutePath} is created")
      case Failure(ex) ⇒ println(s" Failed to creat directory: $expectedDir due to: $ex")
    }*/

    println(new File(expectedDir).mkdirs())
  }

  def createPath(path: String) = {
    val pathList: List[String] = path.split("/").toList

    @tailrec
    def recursivePath(leftPath: List[String], curPath: Try[File]): Try[File] = {
      if (leftPath == Nil) curPath
      else curPath match {
        case Success(path) ⇒ recursivePath(leftPath.tail, makePath(path + "/" + leftPath.head))
        case Failure(ex) ⇒ throw ex
      }
    }
    recursivePath(pathList.tail, makePath(pathList.head))
  }

  def makePath(path: String): Try[File] = Try {
    val curPath = new File(path)

    if (!curPath.exists()) {
      if (curPath.mkdir()) curPath
      else throw new RuntimeException(s"Error while creating path $path")
    } else curPath
  }
}
