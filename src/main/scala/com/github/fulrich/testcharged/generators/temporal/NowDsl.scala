package com.github.fulrich.testcharged.generators.temporal

import java.time._


trait NowDsl {
  def now(fixedInstant: Instant, fixedZone: ZoneOffset = ZoneOffset.UTC): NowProvider = new NowProvider {
    override def apply(): Clock =
      Clock.fixed(fixedInstant, fixedZone)
  }

  def now(fixedLocalDateTime: LocalDateTime): NowProvider = new NowProvider {
    override def apply(): Clock =
      Clock.fixed(Instant.ofEpochSecond(fixedLocalDateTime.toEpochSecond(ZoneOffset.UTC)), ZoneOffset.UTC)
  }
}
