package com.github.fulrich.testcharged.generators

import com.github.fulrich.testcharged.generators.api.{DefaultApi, SizeApi}
import org.scalacheck.Gen


trait DefaultSizeGenerator[T] extends SizeApi[Gen[T]] with DefaultGenerationSizes with DefaultApi[T]{
  def apply(maximum: Long): Gen[T] = apply(Minimum, maximum)
  def apply(minimum: Long, maximum: Long): Gen[T] = {
    require(minimum < maximum, s"Your minimum value ($minimum) must be less than your maximum ($maximum).")
    generate(minimum, maximum)
  }

  override lazy val tiny: Gen[T] = apply(Minimum, TinyMaximum)
  override lazy val small: Gen[T] = apply(TinyMaximum, ShortMaximum)
  override lazy val default: Gen[T] = apply(ShortMaximum, DefaultMaximum)
  override lazy val large: Gen[T] = apply(DefaultMaximum, BigMaximum)
  override lazy val huge: Gen[T] = apply(BigMaximum, HugeMaximum)

  protected def generate(minimum: Long, maximum: Long): Gen[T]
}
