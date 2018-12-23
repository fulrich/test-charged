package com.github.fulrich.testcharged.generators.temporal.instant

import java.time.{Instant, LocalDateTime, Month, ZoneOffset}

import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalTesting}


class InstantGeneratorsUTest extends TemporalTesting with InstantRanges {
  val CurrentDateTime: LocalDateTime = LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0)
  val CurrentInstant: Instant = Instant.ofEpochSecond(CurrentDateTime.toEpochSecond(ZoneOffset.UTC))
  implicit val NowProvider: NowProvider = now(CurrentInstant)


  test ("Ensure LocalDate generation helpers generate within the defined presets") {
    forAll(InstantGenerators.distancePast) { withinRange(CurrentInstant.minus(DistantPast), CurrentInstant) }
    forAll(InstantGenerators.past) { withinRange(CurrentInstant.minus(Past), CurrentInstant) }
    forAll(InstantGenerators.recent) { withinRange(CurrentInstant.minus(Recent), CurrentInstant) }

    forAll(InstantGenerators.default) { withinRange(CurrentInstant.minus(Recent), CurrentInstant.plus(Soon)) }

    forAll(InstantGenerators.soon) { withinRange(CurrentInstant, CurrentInstant.plus(Soon)) }
    forAll(InstantGenerators.future) { withinRange(CurrentInstant, CurrentInstant.plus(Future)) }
    forAll(InstantGenerators.distantFuture) { withinRange(CurrentInstant, CurrentInstant.plus(DistantFuture)) }
  }
}
