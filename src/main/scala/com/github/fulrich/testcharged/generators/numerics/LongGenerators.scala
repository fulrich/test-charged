package com.github.fulrich.testcharged.generators.numerics


object LongGenerators extends NumericGenerator[Long] {
  override val Minimum: Long = Long.MinValue
  override val TinyMaximum: Long = 25
  override val ShortMaximum: Long = 250
  override val DefaultMaximum: Long = 5000
  override val BigMaximum: Long = 20000
  override val HugeMaximum: Long = Long.MaxValue
}
