package com.learning.basics.netty.server

import com.learning.basics.netty.handler.{IdleConnectionHandler, TcpServerHandler}
import com.learning.basics.netty.pipeline.TcpPipeline
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel

import scala.concurrent.duration.MILLISECONDS

class TcpServer(port: Int)
  extends Runnable {

  private val serverBootstrap = new ServerBootstrap
  private val group = new NioEventLoopGroup

  private val idleConnectionHandlerSupplier = () => new IdleConnectionHandler(3000, MILLISECONDS)

  private val telnetServerHandler: ChannelInboundHandlerAdapter = new TcpServerHandler()

  override def run(): Unit =
    try {
      serverBootstrap.group(group)
        .channel(classOf[NioServerSocketChannel])
        .localAddress(port)
        .childHandler(new TcpPipeline(idleConnectionHandlerSupplier, telnetServerHandler))

      serverBootstrap.bind.sync.channel.closeFuture.sync
    } finally {
      group.shutdownGracefully().sync()
    }
}
