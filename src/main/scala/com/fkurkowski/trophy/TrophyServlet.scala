package com.fkurkowski.trophy

import org.scalatra._
import scalate.ScalateSupport

class TrophyServlet extends TrophyRoomStack {

  get("/") {
    contentType = "text/html"
    mustache("index")
  }

}
