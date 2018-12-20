package com.github.fulrich.testcharged.generators.temporal

import java.time.{LocalDate, LocalDateTime, LocalTime, ZoneOffset}


trait TemporalOrdering {
  implicit val localDateTimeOrdering: Ordering[LocalDateTime] = Ordering.by(_.toEpochSecond(ZoneOffset.UTC))
  implicit val localDateOrdering: Ordering[LocalDate] = Ordering.by(_.toEpochDay)
  implicit val localTimeOrdering: Ordering[LocalTime] = Ordering.by(_.toEpochSecond(LocalDate.EPOCH, ZoneOffset.UTC))
}
