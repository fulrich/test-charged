package com.github.fulrich.testcharged.generators.temporal

import java.time.temporal.{Temporal, TemporalAmount}

import org.scalacheck.Gen


trait TemporalGenerator[A <: Temporal] extends TemporalRanges {

  implicit private class TemporalOps(temporal: A) {
    def typedPlus(amount: TemporalAmount): A = temporal.plus(amount).asInstanceOf[A]
    def typedMinus(amount: TemporalAmount): A = temporal.minus(amount).asInstanceOf[A]
  }


  def distancePast(implicit now: NowProvider): Gen[A] = apply(min = _.typedMinus(DistantPast))
  def past(implicit now: NowProvider): Gen[A] = apply(min = _.typedMinus(Past))
  def recent(implicit now: NowProvider): Gen[A] = apply(min = _.typedMinus(Recent))

  def default(implicit now: NowProvider): Gen[A] = apply(min = _.typedMinus(Recent), max = _.typedPlus(Soon))

  def soon(implicit now: NowProvider): Gen[A] = apply(max = _.typedPlus(Soon))
  def future(implicit now: NowProvider): Gen[A] = apply(max = _.typedPlus(Future))
  def distantFuture(implicit now: NowProvider): Gen[A] = apply(max = _.typedPlus(DistantFuture))


  def apply(min: A => A = identity[A], max: A => A = identity[A])(implicit now: NowProvider): Gen[A]
}
