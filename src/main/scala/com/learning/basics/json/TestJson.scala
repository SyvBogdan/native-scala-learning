package com.learning.basics.json

import java.lang.Class.forName

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.learning.basics.json.message.EventRequest
import net.liftweb.json._

object TestJson {

  def main(args: Array[String]): Unit = {

    val rawJson = """{ "eventId":380, "subscriberId":"380671234567","eventTime":"2020-03-13T13:38:04", "subscriberType":0, "params":{ "orderId":"01234567",  "orderChangeStatusDate":"2020-03-13T13:38:04",  "featureId":"4066", "actionType":"аctivate","orderStatus":"1"}}"""
   // import net.liftweb.json._
    implicit val formats = DefaultFormats

    val clazz = forName("com.learning.basics.json.message.EventRequest")

   val objectFromJson = parse(rawJson).extract[EventRequest]

    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)

    val obj = objectMapper.readValue(rawJson, classOf[EventRequest] )

    println(obj)

  }

  /* trait JacksonMapper {

     def jsonSerializer = {
       val m = new ObjectMapper()
       m.registerModule(DefaultScalaModule)
       m
     }


     def deserializeJson[T: Manifest](value: String): T = jsonSerializer.readValue(value, typeReference[T])
     def serializeJson(value: Any) = jsonSerializer.writerWithDefaultPrettyPrinter().writeValueAsString(value)
     def deserializeXml[T: Manifest](value: String): T = xmlSerializer.readValue(value, typeReference[T])
     def serializeXml(value: Any) = xmlSerializer.writeValueAsString(value)

     private[this] def typeReference[T: Manifest] = new TypeReference[T] {
       override def getType = typeFromManifest(manifest[T])
     }

     private[this] def typeFromManifest(m: Manifest[_]): Type = {
       if (m.typeArguments.isEmpty) { m.erasure }
       else new ParameterizedType {
         def getRawType = m.erasure

         def getActualTypeArguments = m.typeArguments.map(typeFromManifest).toArray

         def getOwnerType = null
       }
     }
   }*/

}
