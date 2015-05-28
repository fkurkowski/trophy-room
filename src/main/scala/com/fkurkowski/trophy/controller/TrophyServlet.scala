package com.fkurkowski.trophy.controller

class TrophyServlet extends TrophyRoomStack {

  get("/") {
    contentType = "text/html"
    mustache("index")
  }

}
