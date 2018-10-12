package com.github.fulrich.testcharged.generators.numerics


object DoubleGenerators extends NumericGenerator[Double] {
  override val Minimum: Double = Double.MinValue.toInt
  override val TinyMaximum: Double = 25
  override val ShortMaximum: Double = 1000
  override val DefaultMaximum: Double = 25000
  override val BigMaximum: Double = 250000
  override val HugeMaximum: Double = Double.MaxValue.toInt
}
