package com.learning.basics.netty.handler

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.timeout.{IdleStateEvent, IdleStateHandler}

import scala.concurrent.duration.TimeUnit

class IdleConnectionHandler(timeout: Long, timeUnit: TimeUnit)
  extends IdleStateHandler(timeout, timeout, timeout, timeUnit)  {

  /**
   * This is method is called when IdleStateEvent is fired
   */
  @throws[Exception]
  override protected def channelIdle(ctx: ChannelHandlerContext, evt: IdleStateEvent): Unit = {
    // handle timeout event
    readTimedOut(ctx)
  }

  /**
   * Is called when a read timeout was detected.
   */
  @throws[Exception]
  private def readTimedOut(ctx: ChannelHandlerContext): Unit = {
    ctx.close()
    println("Closed idle TCP/Telnet connection.")
  }
}

