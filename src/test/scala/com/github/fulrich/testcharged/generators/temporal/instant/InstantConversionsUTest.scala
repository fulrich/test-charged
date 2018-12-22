package com.github.fulrich.testcharged.generators.temporal.instant

import java.time.{LocalDate, LocalDateTime, LocalTime, Month}

import org.scalatest.{FunSuite, Matchers}


class InstantConversionsUTest extends FunSuite with Matchers {
  test("Can convert from a LocalDate to an Instant and back to a LocalDate") {
    val testLocalDate = LocalDate.of(2018, Month.JUNE, 20)
    val testLocalDateAsInstant = ToInstant(testLocalDate)
    val testLocalDateFromInstant = FromInstant.toLocalDate(testLocalDateAsInstant)

    testLocalDate shouldBe testLocalDateFromInstant
  }

  test("Can convert from a LocalTime to an Instant and back to a LocalTime") {
    val testLocalTime = LocalTime.of(4, 30)
    val testLocalTimeAsInstant = ToInstant(testLocalTime)
    val testLocalTimeFromInstant = FromInstant.toLocalTime(testLocalTimeAsInstant)

    testLocalTime shouldBe testLocalTimeFromInstant
  }

  test("Can convert from a LocalDateTime to an Instant and back to a LocalDateTime") {
    val testLocalDate = LocalDate.of(2018, Month.JUNE, 20)
    val testLocalTime = LocalTime.of(4, 30)
    val testLocalDateTime = LocalDateTime.of(testLocalDate, testLocalTime)

    val testLocalDateTimeAsInstant = ToInstant(testLocalDateTime)
    val testLocalDateTimeFromInstant = FromInstant.toLocalDateTime(testLocalDateTimeAsInstant)

    testLocalDateTime shouldBe testLocalDateTimeFromInstant
  }
}
