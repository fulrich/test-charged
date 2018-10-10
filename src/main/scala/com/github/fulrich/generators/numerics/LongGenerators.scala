package com.github.fulrich.generators.numerics


object LongGenerators extends NumericGenerator[Long] {
  override val Minimum: Int = Long.MinValue.toInt
  override val TinyMaximum: Int = 25
  override val ShortMaximum: Int = 250
  override val DefaultMaximum: Int = 5000
  override val BigMaximum: Int = 20000
  override val HugeMaximum: Int = Long.MaxValue.toInt
}
