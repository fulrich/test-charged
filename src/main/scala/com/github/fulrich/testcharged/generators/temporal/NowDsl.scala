package com.github.fulrich.testcharged.generators.temporal

import java.time._

import com.github.fulrich.testcharged.generators.temporal.instant.ToInstant


trait NowDsl {
  def now(fixedInstant: Instant, fixedZone: ZoneOffset = ZoneOffset.UTC): NowProvider = new NowProvider {
    override def apply(): Clock = Clock.fixed(fixedInstant, fixedZone)
  }

  def now(fixedLocalDateTime: LocalDateTime): NowProvider = new NowProvider {
    override def apply(): Clock = Clock.fixed(ToInstant(fixedLocalDateTime), ZoneOffset.UTC)
  }

  def now(fixedZonedDateTime: ZonedDateTime): NowProvider = new NowProvider {
    override def apply(): Clock = Clock.fixed(ToInstant(fixedZonedDateTime), fixedZonedDateTime.getZone)
  }
}
