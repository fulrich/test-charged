package com.github.fulrich.testcharged.generators.temporal.dates

import java.time.ZonedDateTime

import com.github.fulrich.testcharged.generators.temporal.instant.{FromInstant, InstantGenerators, ToInstant}
import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object ZonedDateTimeGenerators extends TemporalGenerator[ZonedDateTime] with DateRanges {
  private type Edge = ZonedDateTime => ZonedDateTime
  private val Default: Edge = identity[ZonedDateTime]


  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[ZonedDateTime] = for {
    createdInstant <- InstantGenerators(ToInstant(min(now.zonedDateTime)), ToInstant(max(now.zonedDateTime)))
  } yield FromInstant.toZonedDateTime(createdInstant, now.zone)
}
