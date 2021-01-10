package com.learning.basics.netty

import java.util.concurrent.Executors

import com.learning.basics.netty.server.TcpServer
import io.netty.bootstrap.ServerBootstrap

object TcpServerLaunch {

  def main(args: Array[String]): Unit = {

    val executor = Executors.newSingleThreadExecutor();

    executor.execute(new TcpServer(8080))

  }

}
