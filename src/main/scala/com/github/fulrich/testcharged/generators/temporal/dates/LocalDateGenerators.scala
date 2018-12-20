package com.github.fulrich.testcharged.generators.temporal.dates

import java.time._

import com.github.fulrich.testcharged.generators.temporal.instant.InstantGenerators
import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object LocalDateGenerators extends TemporalGenerator[LocalDate] with DateRanges {
  private type Edge = LocalDate => LocalDate
  private val Default: Edge = identity[LocalDate]


  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[LocalDate] = for {
    createdInstant <- InstantGenerators(
      Instant.ofEpochSecond(min(now.localDate).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.UTC)),
      Instant.ofEpochSecond(max(now.localDate).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.UTC)),
    )
  } yield LocalDate.ofInstant(createdInstant, ZoneOffset.UTC)
}
