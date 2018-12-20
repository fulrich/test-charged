package com.github.fulrich.testcharged.generators.temporal

import java.time._

import org.scalatest.{FunSuite, Matchers}


class NowDslUTest extends FunSuite with Matchers with NowDsl {
  private val LocalDateEpoch = Instant.EPOCH.atZone(ZoneOffset.UTC).toLocalDate
  private val LocalTimeEpoch = Instant.EPOCH.atZone(ZoneOffset.UTC).toLocalTime

  test("Can generate a NowProvider from an Instant") {
    val nowProvider = now(Instant.EPOCH)

    nowProvider.localDate shouldBe LocalDateEpoch
    nowProvider.localTime shouldBe LocalTimeEpoch
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(LocalDateEpoch, LocalTimeEpoch)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }

  test("Can generate a NowProvider from an LocalDateTime") {
    val nowProvider = now(LocalDateTime.of(LocalDateEpoch, LocalTimeEpoch))

    nowProvider.localDate shouldBe LocalDateEpoch
    nowProvider.localTime shouldBe LocalTimeEpoch
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(LocalDateEpoch, LocalTime.MIDNIGHT)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }
}
