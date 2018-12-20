package com.github.fulrich.testcharged.generators.temporal

import java.time.temporal.TemporalAmount


trait TemporalRanges {
  protected val DistantPast: TemporalAmount
  protected val Past: TemporalAmount
  protected val Recent: TemporalAmount

  protected val Soon: TemporalAmount
  protected val Future: TemporalAmount
  protected val DistantFuture: TemporalAmount
}
