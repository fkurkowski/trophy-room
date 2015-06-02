package com.fkurkowski.trophy.controller

import com.fkurkowski.trophy.domain.Tables.videos
import org.scalatra.{AsyncResult, FutureSupport}
import slick.driver.H2Driver.api._
import scala.concurrent.ExecutionContext
import scala.util.Random


class TrophyServlet(db: Database) extends TrophyRoomStack with FutureSupport {

  protected implicit def executor: ExecutionContext = ExecutionContext.Implicits.global

  before() {
    contentType = "text/html"
  }

  get("/") {
    db.run(videos.findRandom.result) map { v =>
      mustache("index", "video" -> v)
    }
  }

  get("/videos") {
    mustache("new")
  }
}
