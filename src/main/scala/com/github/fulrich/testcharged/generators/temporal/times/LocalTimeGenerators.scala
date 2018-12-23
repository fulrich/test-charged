package com.github.fulrich.testcharged.generators.temporal.times

import java.time.LocalTime

import com.github.fulrich.testcharged.generators.temporal.instant.{FromInstant, InstantGenerators, ToInstant}
import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object LocalTimeGenerators extends TemporalGenerator[LocalTime] with TimeRanges {
  private type Edge = LocalTime => LocalTime
  private val Default: Edge = identity[LocalTime]

  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[LocalTime] = for {
    createdInstant <- InstantGenerators(ToInstant(min(now.localTime)), ToInstant(max(now.localTime)))
  } yield FromInstant.toLocalTime(createdInstant)
}
