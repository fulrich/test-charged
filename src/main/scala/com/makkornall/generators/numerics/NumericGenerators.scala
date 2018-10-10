package com.makkornall.generators.numerics


trait NumericGenerators {
  val short: NumericGenerator[Short] = ShortGenerators
  val int: NumericGenerator[Int] = IntGenerators
  val long: NumericGenerator[Long] = LongGenerators
}
