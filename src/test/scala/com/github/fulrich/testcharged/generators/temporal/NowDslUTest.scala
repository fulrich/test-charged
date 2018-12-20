package com.github.fulrich.testcharged.generators.temporal

import java.time._

import org.scalatest.{FunSuite, Matchers}


class NowDslUTest extends FunSuite with Matchers with NowDsl {

  test("Can generate a NowProvider from an Instant") {
    val nowProvider = now(Instant.EPOCH)

    nowProvider.localDate shouldBe LocalDate.EPOCH
    nowProvider.localTime shouldBe LocalTime.MIDNIGHT
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(LocalDate.EPOCH, LocalTime.MIDNIGHT)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }

  test("Can generate a NowProvider from an LocalDateTime") {
    val nowProvider = now(LocalDateTime.of(LocalDate.EPOCH, LocalTime.MIDNIGHT))

    nowProvider.localDate shouldBe LocalDate.EPOCH
    nowProvider.localTime shouldBe LocalTime.MIDNIGHT
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(LocalDate.EPOCH, LocalTime.MIDNIGHT)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }
}
