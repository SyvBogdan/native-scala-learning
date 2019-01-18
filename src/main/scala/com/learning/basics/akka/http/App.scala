package com.learning.basics.akka.http

import java.io.InputStream
import java.security.{SecureRandom, KeyStore}
import javax.net.ssl.{SSLContext, TrustManagerFactory, KeyManagerFactory}

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{Route, Directives}
import akka.http.scaladsl.{ConnectionContext, HttpsConnectionContext, Http}
import akka.stream.ActorMaterializer
import com.typesafe.sslconfig.akka.AkkaSSLConfig

object App extends Directives {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("Https-akka-server")
    implicit val mat = ActorMaterializer()
    implicit val dispatcher = system.dispatcher

    val password: Array[Char] = "qwerty".toCharArray

    val ks: KeyStore = KeyStore.getInstance("JKS") // PKCS12
    val keystore: InputStream = getClass.getClassLoader.getResourceAsStream("httpsscala.jks")

    require(keystore != null, "Keystore required!")
    ks.load(keystore, password)

    val keyManagerFactory: KeyManagerFactory = KeyManagerFactory.getInstance("SunX509")
    keyManagerFactory.init(ks, password)

    val tmf: TrustManagerFactory = TrustManagerFactory.getInstance("SunX509")
    tmf.init(ks)

    val sslContext: SSLContext = SSLContext.getInstance("TLS")
    sslContext.init(keyManagerFactory.getKeyManagers, tmf.getTrustManagers, new SecureRandom)
    val https: HttpsConnectionContext = ConnectionContext.https(sslContext)

    val commonRoutes: Route = get { complete("Hello world!") }
    Http().bindAndHandle(commonRoutes, "127.0.0.1", 443, connectionContext = https)
    Http().bindAndHandle(commonRoutes, "127.0.0.1", 80)

    println("Start Server...")
  }
}
