package com.github.fulrich.testcharged.generators.temporal.instant

import java.time._


object FromInstant {
  def toLocalDate(instant: Instant): LocalDate = LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDate
  def toLocalTime(instant: Instant): LocalTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalTime
  def toLocalDateTime(instant: Instant): LocalDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC)
  def toZonedDateTime(instant: Instant, zone: ZoneId): ZonedDateTime = instant.atZone(zone)
}
