package com.learning.basics.future

import java.util.concurrent.TimeUnit.SECONDS
import java.util.concurrent.{ExecutorService, Executors, TimeUnit}

import com.learning.basics.future.Global.globalCounter

trait GlobalExecutor {
  val pool: ExecutorService = Executors.newFixedThreadPool(100)

  val scheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

  scheduledExecutorService.scheduleAtFixedRate(() => {

    println(s"Already Consumed: ${globalCounter.get()}")
  }, 2L, 1, SECONDS)

}
