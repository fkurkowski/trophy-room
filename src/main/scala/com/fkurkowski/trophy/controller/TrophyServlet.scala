package com.fkurkowski.trophy.controller

import com.fkurkowski.trophy.domain.VideoStore

class TrophyServlet extends TrophyRoomStack {

  get("/") {
    contentType = "text/html"
    mustache("index", "video" -> VideoStore.random)
  }
}
