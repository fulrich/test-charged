package com.github.fulrich.testcharged.generators

import com.github.fulrich.testcharged.generators.api.SizeApi
import org.scalacheck.Gen


trait DefaultSizeGenerator[T] extends SizeApi[Gen[T]] with DefaultGenerationSizes {
  def apply(maximum: Long): Gen[T] = apply(Minimum, maximum)
  def apply(minimum: Long, maximum: Long): Gen[T] = {
    require(minimum < maximum, s"Your minimum value ($minimum) must be less than your maximum ($maximum).")
    generate(minimum, maximum)
  }

  lazy val tiny: Gen[T] = apply(minimum = 1, maximum = TinyMaximum)
  lazy val short: Gen[T] = apply(TinyMaximum, ShortMaximum)
  lazy val default: Gen[T] = apply(ShortMaximum, DefaultMaximum)
  lazy val big: Gen[T] = apply(DefaultMaximum, BigMaximum)
  lazy val huge: Gen[T] = apply(BigMaximum, HugeMaximum)

  protected def generate(minimum: Long, maximum: Long): Gen[T]
}
