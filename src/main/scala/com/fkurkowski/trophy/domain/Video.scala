package com.fkurkowski.trophy.domain

/**
 * @author fkurkowski.
 */
case class Video(id: Long, idOnProvider: String) {

  /**
   * Returns an embeddable URL
   * @return
   */
  def url: String = s"https://www.youtube.com/embed/$idOnProvider?showinfo=0"
}
