package com.github.fulrich.testcharged.generators.temporal.times

import java.time._

import com.github.fulrich.testcharged.generators.temporal.instant.InstantGenerators
import com.github.fulrich.testcharged.generators.temporal.{Epoch, NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object LocalTimeGenerators extends TemporalGenerator[LocalTime] with TimeRanges {
  private type Edge = LocalTime => LocalTime
  private val Default: Edge = identity[LocalTime]

  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[LocalTime] = for {
    createdInstant <- InstantGenerators(
      Instant.ofEpochSecond(min(now.localTime).atDate(Epoch.LocalDate).atZone(ZoneOffset.UTC).toEpochSecond),
      Instant.ofEpochSecond(max(now.localTime).atDate(Epoch.LocalDate).atZone(ZoneOffset.UTC).toEpochSecond)
    )
  } yield LocalDateTime.ofInstant(createdInstant, ZoneOffset.UTC).toLocalTime
}
