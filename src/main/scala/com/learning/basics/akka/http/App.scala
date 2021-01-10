package com.learning.basics.akka.http

import java.io.InputStream
import java.security.{KeyStore, SecureRandom}
import java.time.LocalTime
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

import javax.net.ssl.{KeyManagerFactory, SSLContext, TrustManagerFactory}
import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.{Directives, Route}
import akka.http.scaladsl.{ConnectionContext, Http, HttpsConnectionContext}
import akka.stream.ActorMaterializer
import akka.stream.StreamRefMessages.Payload
import com.typesafe.sslconfig.akka.AkkaSSLConfig

import scala.collection._
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success}

object App extends Directives {

  import scala.concurrent.ExecutionContext.Implicits.global

  val nextIdentifier = new AtomicInteger(1);

  def main(args: Array[String]): Unit = {


    implicit val system = ActorSystem("Https-akka-server")
    implicit val mat = ActorMaterializer()
    implicit val dispatcher = system.dispatcher

    val password: Array[Char] = "qwerty".toCharArray

    val resources = new mutable.HashMap[Int, String]

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

    val createResource: String ⇒ Route = payload ⇒ {

      val nextRes = nextIdentifier.getAndIncrement()
      resources.put(nextRes, payload)
      complete(OK, s"Resource was successfuly created with ID: $nextRes")
    }

    val commonRoutes: Route = concat {
      pathPrefix("api") {
        get {
          path("all") {
            val all = resources.mkString("; ")
            complete(OK, all)
          } ~
            path(IntNumber) { int => {
              resources.get(int) match {
                case Some(res) ⇒ complete(res)
                case None ⇒ complete(NotFound)
              }
            }
            }
        } ~ post {

          extractRequestBody { payload =>

            val nextRes = nextIdentifier.getAndIncrement()
            resources.put(nextRes, payload)
            complete(OK, s"Resource was successfuly created with ID: $nextRes")

          }

        } ~ put {


          extractRequestBody { payload =>

            path(IntNumber) { id => {
              resources.get(id) match {
                case Some(res) ⇒
                  resources.update(id, payload)
                  complete(OK, s"Resource with identifier $id was successfully changed")

                case None ⇒ createResource(payload)
              }
            }
            }

          }
        } ~ delete {
          path(IntNumber) { resource ⇒

            resources.get(resource) match {
              case Some(_) ⇒ resources.remove(resource)
                complete(OK, s"Resource was successfuly removed with ID: $resource")
              case None ⇒ complete(StatusCodes.NotFound, s"Resource was not found with ID: $resource")
            }


          }
        }

      }
    }


    get {
      val time = LocalTime.now()
      complete(s"Привіт Настінька!!!! ;)  ${java.time.LocalDate.now}, time $time")
    }
    //Http().bindAndHandle(commonRoutes, "0.0.0.0", 443, connectionContext = https)
    Http().bindAndHandle(commonRoutes, "0.0.0.0", 8080)

    //   Http().bindAndHandle(commonRoutes, "192.168.1.73", 8080)

    //  Http().bindAndHandle(commonRoutes, "127.0.0.1", 8080)

    println("Start Server...")


  }


  def extractRequestBody(next: String => Route): Route =
    extractRequestEntity { request =>
      extractMaterializer { implicit materializer =>
        onComplete(request.toStrict(FiniteDuration(3, TimeUnit.SECONDS)).map {
          _.data
        } map (_.utf8String)) {
          case Success(body) => next(body)
          case Failure(ex) => complete(BadRequest, s"Body extract failed: ${ex.toString}")
        }
      }
    }

  val extractRequestBodyFunc: ((String => Route) ⇒ Route) = next ⇒
    extractRequestEntity { request =>
      extractMaterializer { implicit materializer =>
        onComplete(request.toStrict(FiniteDuration(3, TimeUnit.SECONDS)).map {
          _.data
        } map (_.utf8String)) {
          case Success(body) => next(body)
          case Failure(ex) => complete(BadRequest, s"Body extract failed: ${ex.toString}")
        }
      }
    }
}
