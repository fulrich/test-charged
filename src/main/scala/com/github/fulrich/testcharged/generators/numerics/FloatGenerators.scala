package com.github.fulrich.testcharged.generators.numerics


object FloatGenerators extends NumericGenerator[Float] {
  override val Minimum: Float = Float.MinValue.toInt
  override val TinyMaximum: Float = 25
  override val ShortMaximum: Float = 1000
  override val DefaultMaximum: Float = 25000
  override val BigMaximum: Float = 250000
  override val HugeMaximum: Float = Float.MaxValue.toInt
}
