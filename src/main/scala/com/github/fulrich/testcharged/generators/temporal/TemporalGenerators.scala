package com.github.fulrich.testcharged.generators.temporal

import java.time._

import com.github.fulrich.testcharged.generators.temporal.dates.{LocalDateGenerators, LocalDateTimeGenerators, ZonedDateTimeGenerators}
import com.github.fulrich.testcharged.generators.temporal.instant.InstantGenerators
import com.github.fulrich.testcharged.generators.temporal.times.LocalTimeGenerators


trait TemporalGenerators extends NowDsl {
  val zonedDateTime: TemporalGenerator[ZonedDateTime] = ZonedDateTimeGenerators
  val localDateTime: TemporalGenerator[LocalDateTime] = LocalDateTimeGenerators
  val localDate: TemporalGenerator[LocalDate] = LocalDateGenerators
  val localTime: TemporalGenerator[LocalTime] = LocalTimeGenerators
  val instant: TemporalGenerator[Instant] = InstantGenerators
}
