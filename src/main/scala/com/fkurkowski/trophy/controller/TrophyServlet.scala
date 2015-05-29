package com.fkurkowski.trophy.controller

import com.fkurkowski.trophy.domain.VideoStore

class TrophyServlet extends TrophyRoomStack {

  before() {
    contentType = "text/html"
  }

  get("/") {
    mustache("index", "video" -> VideoStore.random)
  }

  get("/videos") {
    mustache("new")
  }
}
