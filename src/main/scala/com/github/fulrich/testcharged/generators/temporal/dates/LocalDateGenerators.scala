package com.github.fulrich.testcharged.generators.temporal.dates

import java.time.LocalDate

import com.github.fulrich.testcharged.generators.temporal.instant.{FromInstant, InstantGenerators, ToInstant}
import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object LocalDateGenerators extends TemporalGenerator[LocalDate] with DateRanges {
  private type Edge = LocalDate => LocalDate
  private val Default: Edge = identity[LocalDate]


  def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[LocalDate] = for {
    createdInstant <- InstantGenerators(ToInstant(min(now.localDate)), ToInstant(max(now.localDate)))
  } yield FromInstant.toLocalDate(createdInstant)
}
