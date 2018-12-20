package com.github.fulrich.testcharged.generators.temporal

import java.time._

import org.scalatest.{FunSuite, Matchers}


class NowDslUTest extends FunSuite with Matchers with NowDsl {
  test("Can generate a NowProvider from an Instant") {
    val nowProvider = now(Instant.EPOCH)

    nowProvider.localDate shouldBe Epoch.LocalDate
    nowProvider.localTime shouldBe Epoch.LocalTime
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(Epoch.LocalDate, Epoch.LocalTime)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }

  test("Can generate a NowProvider from an LocalDateTime") {
    val nowProvider = now(LocalDateTime.of(Epoch.LocalDate, Epoch.LocalTime))

    nowProvider.localDate shouldBe Epoch.LocalDate
    nowProvider.localTime shouldBe Epoch.LocalTime
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(Epoch.LocalDate, LocalTime.MIDNIGHT)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }
}
