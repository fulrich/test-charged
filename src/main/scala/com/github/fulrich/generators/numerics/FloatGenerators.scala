package com.github.fulrich.generators.numerics


object FloatGenerators extends NumericGenerator[Float] {
  override val Minimum: Int = Float.MinValue.toInt
  override val TinyMaximum: Int = 25
  override val ShortMaximum: Int = 1000
  override val DefaultMaximum: Int = 25000
  override val BigMaximum: Int = 250000
  override val HugeMaximum: Int = Float.MaxValue.toInt
}
