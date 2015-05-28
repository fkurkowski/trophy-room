package com.fkurkowski.trophy.domain

/**
 * @author fkurkowski.
 */
case class Video(id: Long, idOnProvider: String, provider: Provider) {

  /**
   * Returns an embeddable URL
   * @return
   */
  def url: String = provider match {
    case YouTube => s"https://www.youtube.com/embed/$idOnProvider?showinfo=0"
    case Dailymotion => s"https://www.dailymotion.com/embed/video/$idOnProvider"
  }
}

sealed abstract class Provider
case object YouTube extends Provider
case object Dailymotion extends Provider