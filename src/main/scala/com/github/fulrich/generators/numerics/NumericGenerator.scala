package com.github.fulrich.generators.numerics

import com.github.fulrich.generators.api.{GenerationSizes, SizeApi}
import org.scalacheck.Gen
import org.scalacheck.Gen.Choose


abstract class NumericGenerator[T : Numeric : Choose] extends SizeApi[SignGenerator[T]] with GenerationSizes {
  val numeric: Numeric[T] = implicitly[Numeric[T]]

  def apply(range: Int): SignGenerator[T] = SignGenerator[T](numeric.fromInt(range))
  def apply(minimum: Int, maximum: Int): Gen[T] = {
    require(minimum < maximum, s"Your minimum value ($minimum) must be less than your maximum ($maximum).")
    Gen.chooseNum[T](numeric.fromInt(minimum), numeric.fromInt(maximum))
  }

  override lazy val tiny: SignGenerator[T] = SignGenerator[T](numeric.fromInt(TinyMaximum))
  override lazy val short: SignGenerator[T] = SignGenerator[T](numeric.fromInt(ShortMaximum))
  override lazy val default: SignGenerator[T] = SignGenerator[T](numeric.fromInt(DefaultMaximum))
  override lazy val big: SignGenerator[T] = SignGenerator[T](numeric.fromInt(BigMaximum))
  override lazy val huge: SignGenerator[T] = SignGenerator[T](numeric.fromInt(HugeMaximum))
}
