package com.github.fulrich.testcharged.generators.temporal

import java.time._


trait NowDsl {
  def now(instant: Instant, zone: ZoneOffset = ZoneOffset.UTC): NowProvider =
    () => Clock.fixed(instant, zone)

  def now(localDateTime: LocalDateTime): NowProvider =
    () => Clock.fixed(Instant.ofEpochSecond(localDateTime.toEpochSecond(ZoneOffset.UTC)), ZoneOffset.UTC)
}
