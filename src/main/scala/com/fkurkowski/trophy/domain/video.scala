package com.fkurkowski.trophy.domain

/**
 * @author fkurkowski.
 */
case class Video(id: Long, providerId: Long, videoIdOnProvider: String) {

  /**
   * Returns an embeddable URL
   * @return
   */
  def url: String = providerId match {
    case 1L => s"https://www.youtube.com/embed/$videoIdOnProvider?showinfo=0"
    case 2L => s"https://www.dailymotion.com/embed/video/$videoIdOnProvider"
  }
}

case class Provider(id: Long, name: String)
