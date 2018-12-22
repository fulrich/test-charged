package com.github.fulrich.testcharged.generators.temporal.instant

import java.time._

import com.github.fulrich.testcharged.generators.temporal.Epoch


object ToInstant {
  def apply(localDate: LocalDate): Instant =
    Instant.ofEpochSecond(localDate.atStartOfDay(ZoneOffset.UTC).toEpochSecond)

  def apply(localTime: LocalTime): Instant =
    Instant.ofEpochSecond(localTime.atDate(Epoch.LocalDate).atZone(ZoneOffset.UTC).toEpochSecond)

  def apply(localDateTime: LocalDateTime): Instant =
    localDateTime.toInstant(ZoneOffset.UTC)

  def apply(zonedDateTime: ZonedDateTime): Instant = zonedDateTime.toInstant
}
