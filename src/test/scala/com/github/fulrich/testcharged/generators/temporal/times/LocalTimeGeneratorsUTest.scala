package com.github.fulrich.testcharged.generators.temporal.times

import java.time.{LocalDate, LocalDateTime, LocalTime}

import com.github.fulrich.testcharged.generators.temporal.{NowProvider, TemporalTesting}


class LocalTimeGeneratorsUTest extends TemporalTesting with TimeRanges {
  val CurrentTime: LocalTime = LocalTime.of(12, 30)
  implicit val NowProvider: NowProvider = now(LocalDateTime.of(LocalDate.EPOCH, CurrentTime))

  test ("Ensure LocalTime generation helpers generate within the defined presets") {
    forAll(LocalTimeGenerators.distancePast) { withinRange(CurrentTime.minus(DistantPast), CurrentTime) }
    forAll(LocalTimeGenerators.past) { withinRange(CurrentTime.minus(Past), CurrentTime) }
    forAll(LocalTimeGenerators.recent) { withinRange(CurrentTime.minus(Recent), CurrentTime) }

    forAll(LocalTimeGenerators.default) { withinRange(CurrentTime.minus(Recent), CurrentTime.plus(Soon)) }

    forAll(LocalTimeGenerators.soon) { withinRange(CurrentTime, CurrentTime.plus(Soon)) }
    forAll(LocalTimeGenerators.future) { withinRange(CurrentTime, CurrentTime.plus(Future)) }
    forAll(LocalTimeGenerators.distantFuture) { withinRange(CurrentTime, CurrentTime.plus(DistantFuture)) }
  }
}
