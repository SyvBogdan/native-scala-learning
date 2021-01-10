package com.learning.basics.future

import java.util.UUID
import java.util.UUID.randomUUID
import java.util.concurrent.Executors

import com.learning.basics.future.Global._

import scala.collection.concurrent.TrieMap
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

import scala.concurrent._
import scala.concurrent.duration._

case class Message(id: UUID, message: String)

trait ActionListener {

  def onComplete(message: Message): Unit

  def onFailed(message: Message, ex: Throwable) : Unit

}

object AsyncFutureClient extends GlobalExecutor {

  def main(args: Array[String]): Unit = {

    val exec = Executors.newFixedThreadPool(24)

    val client = new InnerAsyncClient


    exec.submit(new Runnable {
      override def run(): Unit = {
        println("StartProduce")
        for (f <- 1 to 1000000) {
          // sending request async
          //println("sending .....")

          val res =
            client.send("hello").andThen {
              case Success(value) => globalCounter.incrementAndGet()
          //      println(s"Message was sent successfully: ${value.id.toString}")
              case Failure(ex) =>
                println(s"Some exception has occured: $ex")
                globalCounter.incrementAndGet()
            }
          // for test waiting result, but in prod all process with non-blocking pipeline
          //val r = Await.result(res, Duration.apply(10, SECONDS))
          // sequence(List(res, Future(f)))
          // }
        }
      }
    }

    )
  }

  class InnerAsyncClient {

    val trieMap = new TrieMap[UUID, Promise[Message]]()
    val listener = new CallBackListener(trieMap)
    val session = new Session(trieMap, listener)

    def send(message: String) = {
      val cid = randomUUID()
      session.sendAsync(Message(cid, message))
        .andThen {
          case Success(_) =>
           // println(trieMap.size)
            trieMap.remove(cid)
          case Failure(_) => trieMap.remove(cid)
        }
    }
  }

  class CallBackListener(promises: TrieMap[UUID, Promise[Message]]) extends ActionListener {
    override def onComplete(message: Message): Unit =
      promises.get(message.id) match {
        case Some(pair) => pair.success(message)
        case ex => println(s"Some ex: $ex")
      }

    override def onFailed(message: Message, ex: Throwable): Unit = promises.get(message.id) match {
      case Some(pair) => pair.failure(new RuntimeException(ex))
      case _ => println(s"Some ex: $ex")
    }
  }

  class Session(responses: TrieMap[UUID, Promise[Message]], actionListener: ActionListener) {

    val someServer = new SomeServer(actionListener)

    def sendAsync(message: Message): Future[Message] = {
      val nextPromise = Promise[Message]

      responses.put(message.id, nextPromise)
      Future {
        someServer.acceptMessage(message)
      }.onComplete {
        case Success(_) =>
        case Failure(_) =>
      }
      nextPromise.future
    }

  }

  class SomeServer(onFinish: ActionListener) {

    def acceptMessage(message: Message): Unit = {
      Thread.sleep(1)
      onFinish.onComplete(message)
    }
  }

}
