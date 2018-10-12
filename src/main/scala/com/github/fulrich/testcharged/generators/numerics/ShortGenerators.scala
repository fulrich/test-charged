package com.github.fulrich.testcharged.generators.numerics


object ShortGenerators extends NumericGenerator[Short] {
  override val Minimum: Short = Short.MinValue
  override val TinyMaximum: Short = 25
  override val ShortMaximum: Short = 250
  override val DefaultMaximum: Short = 5000
  override val BigMaximum: Short = 20000
  override val HugeMaximum: Short = Short.MaxValue
}
