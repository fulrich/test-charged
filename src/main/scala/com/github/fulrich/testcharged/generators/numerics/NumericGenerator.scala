package com.github.fulrich.testcharged.generators.numerics

import com.github.fulrich.testcharged.generators.api.{DefaultCaller, GenerationSizes, SizeApi}
import org.scalacheck.Gen
import org.scalacheck.Gen.Choose


abstract class NumericGenerator[T : Numeric : Choose] extends SizeApi[SignGenerator[T]] with GenerationSizes[T] {
  val numeric: Numeric[T] = implicitly[Numeric[T]]

  def apply(range: T): SignGenerator[T] = SignGenerator[T](range)
  def apply(minimum: T, maximum: T): Gen[T] = {
    require(numeric.lt(minimum, maximum), s"Your minimum value ($minimum) must be less than your maximum ($maximum).")
    Gen.choose[T](minimum, maximum)
  }

  override lazy val tiny: SignGenerator[T] = apply(TinyMaximum)
  override lazy val small: SignGenerator[T] = apply(ShortMaximum)
  override lazy val default: SignGenerator[T] = apply(DefaultMaximum)
  override lazy val large: SignGenerator[T] = apply(BigMaximum)
  override lazy val huge: SignGenerator[T] = apply(HugeMaximum)
}

object NumericGenerator {
  implicit def numericGeneratorDefaultCaller[T : Numeric : Choose]: DefaultCaller[T, NumericGenerator[T]] =
    new DefaultCaller[T, NumericGenerator[T]] {
      override def apply(callee: NumericGenerator[T]): Gen[T] = callee.default
    }
}
