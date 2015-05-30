package com.fkurkowski.trophy.domain

import slick.driver.H2Driver.api._
/**
 * @author fkurkowski.
 */
object Tables {
  class Providers(tag: Tag) extends Table[(Long, String)](tag, "PROVIDERS") {
    def id = column[Long]("PROVIDER_ID", O.PrimaryKey)
    def name = column[String]("NAME")

    def * = (id, name)
  }

  val providers = TableQuery[Providers]

  class Videos(tag: Tag) extends Table[(Long, Long, String)](tag, "VIDEOS") {
    def id = column[Long]("VIDEO_ID", O.PrimaryKey)
    def providerId = column[Long]("PROVIDER_ID")
    def videoIdOnProvider = column[String]("VIDEO_ID_PROVIDER")

    def * = (id, providerId, videoIdOnProvider)
    def provider = foreignKey("PROVIDER_FK", providerId, providers)(_.id)
  }

  val videos = TableQuery[Videos]

  val setup = DBIO.seq(
    (providers.schema ++ videos.schema).create,
    providers ++= Seq(
      (1L, "YouTube"),
      (2L, "Dailymotion")
    ),
    videos ++= Seq(
      (1L, 1L, "-0ZpuLVjD-Q"),
      (2L, 1L, "cnUAilkXYoM"),
      (3L, 1L, "lP88iRPAcz4"),
      (4L, 2L, "x2ro8p7")
    )
  )
}
