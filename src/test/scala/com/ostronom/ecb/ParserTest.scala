package com.ostronom.ecb

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.stream.ActorMaterializer
import akka.util.ByteString
import org.scalatest._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.language.postfixOps


class ParserTest extends FlatSpec with Matchers with BeforeAndAfterAll {
  behavior of "ECB rates parser"

  implicit val system = ActorSystem.create()
  implicit val mat = ActorMaterializer()
  implicit val ec = system.dispatcher
  implicit val http = Http(system)
  implicit val timeout = 5 seconds
  implicit val httpClient = new HttpClient {
    override def get(url: String): Future[String] = for {
      resp <- http.singleRequest(HttpRequest(uri = url)).flatMap(_.toStrict(timeout))
      data <- resp.entity.dataBytes.runFold(ByteString.empty)(_ ++ _)
    } yield data.utf8String
  }

  override def afterAll() = {
    super.afterAll()
    system.terminate()
  }

  it should "get latest data" in {
    assert(Await.result(Parser.loadLatest(), timeout).exists(_.rates.nonEmpty), "No data could be parsed")
  }

  it should "get 90-day data" in {
    assert(Await.result(Parser.loadLast90Days(), timeout).forall(_.exists(_.rates.nonEmpty)), "No data could be parsed")
  }
}
