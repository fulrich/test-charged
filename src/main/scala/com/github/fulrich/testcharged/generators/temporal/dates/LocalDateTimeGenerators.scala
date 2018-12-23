package com.github.fulrich.testcharged.generators.temporal.dates

import java.time.LocalDateTime

import com.github.fulrich.testcharged.generators.temporal.instant.{FromInstant, InstantGenerators, ToInstant}
import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object LocalDateTimeGenerators extends TemporalGenerator[LocalDateTime] with DateRanges {
  private type Edge = LocalDateTime => LocalDateTime
  private val Default: Edge = identity[LocalDateTime]


  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[LocalDateTime] = for {
    createdInstant <- InstantGenerators(ToInstant(min(now.localDateTime)), ToInstant(max(now.localDateTime)))
  } yield FromInstant.toLocalDateTime(createdInstant)
}
