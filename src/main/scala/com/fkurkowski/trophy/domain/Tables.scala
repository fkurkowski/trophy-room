package com.fkurkowski.trophy.domain

import slick.driver.H2Driver.api._
/**
 * @author fkurkowski.
 */
object Tables {

  class Providers(tag: Tag) extends Table[Provider](tag, "PROVIDERS") {
    def id = column[Long]("PROVIDER_ID", O.PrimaryKey)
    def name = column[String]("NAME")

    def * = (id, name) <> (Provider.tupled, Provider.unapply)
  }

  val providers = TableQuery[Providers]

  class Videos(tag: Tag) extends Table[Video](tag, "VIDEOS") {
    def id = column[Long]("VIDEO_ID", O.PrimaryKey)
    def providerId = column[Long]("PROVIDER_ID")
    def videoIdOnProvider = column[String]("VIDEO_ID_PROVIDER")

    def * = (id, providerId, videoIdOnProvider) <> (Video.tupled, Video.unapply)
    def provider = foreignKey("PROVIDER_FK", providerId, providers)(_.id)
  }

  val videos = TableQuery[Videos]

  val setup = DBIO.seq(
    (providers.schema ++ videos.schema).create,
    providers ++= Seq(
      Provider(1L, "YouTube"),
      Provider(2L, "Dailymotion")
    ),
    videos ++= Seq(
      Video(1L, 1L, "-0ZpuLVjD-Q"),
      Video(2L, 1L, "cnUAilkXYoM"),
      Video(3L, 1L, "lP88iRPAcz4"),
      Video(4L, 2L, "x2ro8p7")
    )
  )
}
