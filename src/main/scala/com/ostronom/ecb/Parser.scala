package com.ostronom.ecb


import java.time.LocalDate
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE

import cats.syntax.traverse._
import cats.instances.vector._
import cats.instances.option._

import scala.collection.immutable.Seq
import scala.xml._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try


trait HttpClient {
  def get(url: String): Future[String]
}


object Parser {
  private def parseItemCube(node: Node): Option[Rate] = for {
    currencyString <- node.attribute("currency").map(_.text)
    currency <- Try(Currency.fromString(currencyString)).toOption
    rateString <- node.attribute("rate").map(_.text)
    rate <- Try(rateString.toDouble).toOption
  } yield Rate(currency, rate)

  private def parseDayCube(node: Node): Option[DayRates] = for {
    timeSeq <- node.attribute("time")
    timeStr <- timeSeq.headOption
    time = LocalDate.parse(timeStr.text.trim, ISO_LOCAL_DATE)
    items <- (node \ "Cube").map(parseItemCube).toVector.sequence
  } yield DayRates(time, items)

  private val latestUrl = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml"
  private val last90DaysUrl = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml"

  private def getCubes(url: String)(implicit client: HttpClient, ec: ExecutionContext) =
    client.get(url).map(s => XML.loadString(s) \ "Cube" \ "Cube")

  def loadLatest()(implicit client: HttpClient, ec: ExecutionContext): Future[Option[DayRates]] =
    getCubes(latestUrl).map(_.headOption.flatMap(parseDayCube))

  def loadLast90Days()(implicit client: HttpClient, ec: ExecutionContext): Future[Seq[Option[DayRates]]] =
    getCubes(last90DaysUrl).map(_.map(parseDayCube))
}