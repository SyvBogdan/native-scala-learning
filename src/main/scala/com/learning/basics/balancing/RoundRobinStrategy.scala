package com.learning.basics.balancing

import java.lang.Math.abs
import java.util.concurrent.atomic.{AtomicInteger, AtomicLong}

class RoundRobinStrategy {

  val cur = new AtomicInteger(0)
  val list = List()


  def getNext = if (list.nonEmpty && list != null)
    abs(cur.accumulateAndGet(0, (prev, _) => {
      if (prev < Integer.MAX_VALUE) prev + 1 else 0
    }) % list.size)
  else -1
}
