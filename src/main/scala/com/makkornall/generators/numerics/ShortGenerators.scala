package com.makkornall.generators.numerics


object ShortGenerators extends NumericGenerator[Short] {
  override val Minimum: Int = Short.MinValue
  override val TinyMaximum: Int = 25
  override val ShortMaximum: Int = 250
  override val DefaultMaximum: Int = 5000
  override val BigMaximum: Int = 20000
  override val HugeMaximum: Int = Short.MaxValue
}
