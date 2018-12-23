package com.github.fulrich.testcharged.generators.temporal

import java.time._

import com.github.fulrich.testcharged.generators.temporal.instant.{FromInstant, ToInstant}
import org.scalatest.{FunSuite, Matchers}


class NowDslUTest extends FunSuite with Matchers with NowDsl {
  test("Can generate a NowProvider from a Instant") {
    val nowProvider = now(Instant.EPOCH)

    nowProvider.localDate shouldBe Epoch.LocalDate
    nowProvider.localTime shouldBe Epoch.LocalTime
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(Epoch.LocalDate, Epoch.LocalTime)
    nowProvider.zonedDateTime shouldBe FromInstant.toZonedDateTime(Instant.EPOCH, ZoneOffset.UTC)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }

  test("Can generate a NowProvider from a LocalDateTime") {
    val nowProvider = now(LocalDateTime.of(Epoch.LocalDate, Epoch.LocalTime))

    nowProvider.localDate shouldBe Epoch.LocalDate
    nowProvider.localTime shouldBe Epoch.LocalTime
    nowProvider.instant shouldBe Instant.EPOCH
    nowProvider.localDateTime shouldBe LocalDateTime.of(Epoch.LocalDate, LocalTime.MIDNIGHT)
    nowProvider.zonedDateTime shouldBe ZonedDateTime.of(Epoch.LocalDate, Epoch.LocalTime, ZoneOffset.UTC)
    nowProvider.zone shouldBe ZoneOffset.UTC
  }

  test("Can generate a NowProvider from a ZonedDateTime") {
    val date = LocalDate.of(2018, Month.JUNE, 20)
    val time = LocalTime.of(11, 30)
    val zone = Clock.systemDefaultZone.getZone
    val zonedDateTime = ZonedDateTime.of(date, time, zone)
    val nowProvider = now(zonedDateTime)

    nowProvider.localDate shouldBe date
    nowProvider.localTime shouldBe time
    nowProvider.instant shouldBe ToInstant(zonedDateTime)
    nowProvider.localDateTime shouldBe LocalDateTime.of(date, time)
    nowProvider.zonedDateTime shouldBe zonedDateTime
    nowProvider.zone shouldBe zone
  }
}
