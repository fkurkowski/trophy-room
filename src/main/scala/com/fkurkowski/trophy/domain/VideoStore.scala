package com.fkurkowski.trophy.domain

import java.util.Random

/**
 * Just for early development purposes, while we do not have a persistence layer.
 * @author fkurkowski.
 */
object VideoStore {
  private[this] val videos = List(
    Video(1L, "-0ZpuLVjD-Q", YouTube),
    Video(1L, "cnUAilkXYoM", YouTube),
    Video(1L, "lP88iRPAcz4", YouTube),
    Video(1L, "x2ro8p7", Dailymotion)
  )

  private val randomGenerator  = new Random()

  /**
   * Returns a random video.
   *
   * @return
   */
  def random: Video = {
    val idx = randomGenerator.nextInt(videos.length)
    videos(idx)
  }
}
