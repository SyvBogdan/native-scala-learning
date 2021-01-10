package com.learning.basics.netty.pipeline

import io.netty.channel.{ChannelInboundHandlerAdapter, ChannelInitializer, ChannelPipeline}
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.Delimiters._
import io.netty.handler.codec.{DelimiterBasedFrameDecoder, Delimiters}
import io.netty.handler.codec.string.{StringDecoder, StringEncoder}
import io.netty.handler.timeout.IdleStateHandler

class TcpPipeline(idleConnectionHandler: () => IdleStateHandler,
                  telnetServerHandler: ChannelInboundHandlerAdapter)
  extends ChannelInitializer[SocketChannel] {

  private val decoder = new StringDecoder
  private val encoder = new StringEncoder

  @throws[Exception]
  override def initChannel(ch: SocketChannel): Unit = {
    val pipeline: ChannelPipeline = ch.pipeline()

    pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, lineDelimiter().toSeq:_*))
      .addLast("decoder", decoder)
      .addLast("encoder", encoder)
      .addLast("idleConnectionHandler", idleConnectionHandler.apply())
      .addLast("serverHandler", telnetServerHandler)
  }
}
