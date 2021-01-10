package com.learning.basics.netty.handler

import akka.util.ByteString.UTF_8
import com.learning.basics.netty.config.Config.{executedString, newLine, stringPrompt}
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}
import javax.xml.bind.DatatypeConverter._

@Sharable
class TcpServerHandler extends ChannelInboundHandlerAdapter {

  private val executed: String = new StringBuilder(executedString)
    .append(newLine)
    .append(stringPrompt).toString

  @throws[Exception]
  override def channelActive(ctx: ChannelHandlerContext): Unit =
    ctx.writeAndFlush(stringPrompt)

  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {

    msg match {
      case str: String ⇒
        val hex = printHexBinary(str.getBytes(UTF_8))
        println(str + s": hex($hex)")
        ctx.writeAndFlush(str + executed)

      case _ ⇒ ctx.writeAndFlush(stringPrompt)
    }
  }

}
