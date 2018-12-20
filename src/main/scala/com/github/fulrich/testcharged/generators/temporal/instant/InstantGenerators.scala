package com.github.fulrich.testcharged.generators.temporal.instant

import java.time.Instant

import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalGenerator}
import org.scalacheck.Gen


object InstantGenerators extends TemporalGenerator[Instant] with InstantRanges {
  private type Edge = Instant => Instant
  private val Default: Edge = identity[Instant]


  def apply(min: Instant, max: Instant): Gen[Instant] = for {
    generatedInstant <- Gen.choose(min.getEpochSecond, max.getEpochSecond)
  } yield Instant.ofEpochSecond(generatedInstant)

  override def apply(min: Edge = Default, max: Edge = Default)(implicit now: NowProvider): Gen[Instant] =
    apply(min(now.instant), max(now.instant))
}
