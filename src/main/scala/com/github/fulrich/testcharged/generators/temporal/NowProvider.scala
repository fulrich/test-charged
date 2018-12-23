package com.github.fulrich.testcharged.generators.temporal

import java.time._


trait NowProvider {
  def apply(): Clock

  def instant: Instant = apply().instant
  def zone: ZoneId = apply().getZone

  def localDateTime: LocalDateTime = LocalDateTime.now(apply())
  def localTime: LocalTime = LocalTime.now(apply())
  def localDate: LocalDate = LocalDate.now(apply())
  def zonedDateTime: ZonedDateTime = ZonedDateTime.now(apply())
}

object NowProvider {
  implicit val DefaultNowProvider: NowProvider = new NowProvider {
    override def apply(): Clock = Clock.systemDefaultZone
  }
}
