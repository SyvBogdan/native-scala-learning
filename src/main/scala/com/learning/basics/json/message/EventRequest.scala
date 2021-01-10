package com.learning.basics.json.message

  case class EventRequest(subscriberId: String,
                          eventId: Long,
                          subscriberType: Int,
                          eventTime: String,
                          params: Map[String, String])