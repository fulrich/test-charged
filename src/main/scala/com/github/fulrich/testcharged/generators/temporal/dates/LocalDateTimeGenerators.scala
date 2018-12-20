package com.github.fulrich.testcharged.generators.temporal.dates

import java.time.{LocalDateTime, ZoneOffset}

import com.github.fulrich.testcharged.generators.temporal.instant.InstantGenerators
import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object LocalDateTimeGenerators extends TemporalGenerator[LocalDateTime] with DateRanges {
  private type Edge = LocalDateTime => LocalDateTime
  private val Default: Edge = identity[LocalDateTime]


  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[LocalDateTime] = for {
    createdInstant <- InstantGenerators(
      min(now.localDateTime).toInstant(ZoneOffset.UTC),
      max(now.localDateTime).toInstant(ZoneOffset.UTC)
    )
  } yield LocalDateTime.ofInstant(createdInstant, ZoneOffset.UTC)
}
