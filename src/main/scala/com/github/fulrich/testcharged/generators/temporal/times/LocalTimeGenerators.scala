package com.github.fulrich.testcharged.generators.temporal.times

import java.time.{Instant, LocalDate, LocalTime, ZoneOffset}

import com.github.fulrich.testcharged.generators.temporal.instant.InstantGenerators
import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object LocalTimeGenerators extends TemporalGenerator[LocalTime] with TimeRanges {
  private type Edge = LocalTime => LocalTime
  private val Default: Edge = identity[LocalTime]


  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[LocalTime] = for {
    createdInstant <- InstantGenerators(
      Instant.ofEpochSecond(min(now.localTime).toEpochSecond(LocalDate.EPOCH, ZoneOffset.UTC)),
      Instant.ofEpochSecond(max(now.localTime).toEpochSecond(LocalDate.EPOCH, ZoneOffset.UTC))
    )
  } yield LocalTime.ofInstant(createdInstant, ZoneOffset.UTC)
}
