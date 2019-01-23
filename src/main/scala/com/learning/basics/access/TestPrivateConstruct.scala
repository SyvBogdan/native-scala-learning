package com.learning.basics.access

trait TraitPrivateConstruct

private class TestPrivateConstruct extends TraitPrivateConstruct {
}

object TestPrivateConstruct {
  def createTestPrivateConstruct(): TraitPrivateConstruct = new TestPrivateConstruct
}
