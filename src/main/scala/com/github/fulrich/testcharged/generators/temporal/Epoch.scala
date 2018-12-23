package com.github.fulrich.testcharged.generators.temporal

import java.time.{Instant, LocalDate, LocalTime, ZoneOffset}

object Epoch {
  val LocalDate: LocalDate = Instant.EPOCH.atZone(ZoneOffset.UTC).toLocalDate
  val LocalTime: LocalTime = Instant.EPOCH.atZone(ZoneOffset.UTC).toLocalTime
}
