package com.github.fulrich.testcharged.generators.temporal.dates

import java.time.{Clock, LocalDateTime, Month, ZonedDateTime}

import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalTesting}


class ZonedDateTimeGeneratorsUTest extends TemporalTesting with DateRanges {
  val DateTime: LocalDateTime = LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0)
  val CurrentZone = Clock.systemDefaultZone.getZone
  val CurrentDateTime: ZonedDateTime = DateTime.atZone(CurrentZone)
  implicit val NowProvider: NowProvider = now(CurrentDateTime)

  test ("Ensure ZonedDateTime generation helpers generate within the defined presets") {
    forAll(ZonedDateTimeGenerators.distancePast) { withinRange(CurrentDateTime.minus(DistantPast), CurrentDateTime) }
    forAll(ZonedDateTimeGenerators.past) { withinRange(CurrentDateTime.minus(Past), CurrentDateTime) }
    forAll(ZonedDateTimeGenerators.recent) { withinRange(CurrentDateTime.minus(Recent), CurrentDateTime) }

    forAll(ZonedDateTimeGenerators.default) { withinRange(CurrentDateTime.minus(Recent), CurrentDateTime.plus(Soon)) }

    forAll(ZonedDateTimeGenerators.soon) { withinRange(CurrentDateTime, CurrentDateTime.plus(Soon)) }
    forAll(ZonedDateTimeGenerators.future) { withinRange(CurrentDateTime, CurrentDateTime.plus(Future)) }
    forAll(ZonedDateTimeGenerators.distantFuture) { withinRange(CurrentDateTime, CurrentDateTime.plus(DistantFuture)) }
  }
}
