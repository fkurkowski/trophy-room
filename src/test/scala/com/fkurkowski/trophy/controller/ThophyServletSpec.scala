package com.fkurkowski.trophy.controller

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class ThophyServletSpec extends MutableScalatraSpec {
  addServlet(classOf[TrophyServlet], "/*")

  "GET / on ThophyServlet" should {
    "return status 200" in {
      get("/") {
        status === 200
      }
    }
  }
}
