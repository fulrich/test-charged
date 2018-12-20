package com.github.fulrich.testcharged.generators.temporal

import java.time.{LocalDate, LocalDateTime, LocalTime, ZoneOffset}



trait TemporalOrdering {
  implicit val localDateTimeOrdering: Ordering[LocalDateTime] = Ordering.by(_.toEpochSecond(ZoneOffset.UTC))
  implicit val localDateOrdering: Ordering[LocalDate] = Ordering.by(_.atStartOfDay(ZoneOffset.UTC).toEpochSecond)
  implicit val localTimeOrdering: Ordering[LocalTime] = Ordering.by(_.atDate(Epoch.LocalDate).atZone(ZoneOffset.UTC).toEpochSecond)
}
