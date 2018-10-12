package com.github.fulrich.testcharged.generators.numerics


object DoubleGenerators extends NumericGenerator[Double] {
  override val Minimum: Int = Double.MinValue.toInt
  override val TinyMaximum: Int = 25
  override val ShortMaximum: Int = 1000
  override val DefaultMaximum: Int = 25000
  override val BigMaximum: Int = 250000
  override val HugeMaximum: Int = Double.MaxValue.toInt
}
