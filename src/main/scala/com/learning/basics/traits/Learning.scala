package com.learning.basics.traits

trait Learning /*extends Mentor*/ {

  // in trait it is possible to make method final and protect its future implementation in other traits or subclasses
  final def learnSmth(subject: String) = s" i learn ${subject}"

}
