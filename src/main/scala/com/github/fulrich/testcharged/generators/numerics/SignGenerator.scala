package com.github.fulrich.testcharged.generators.numerics

import com.github.fulrich.testcharged.generators.api.DefaultCaller
import org.scalacheck.Gen
import org.scalacheck.Gen.Choose


case class SignGenerator[T : Choose](range: T)(implicit numeric: Numeric[T]) {
  lazy val positive: Gen[T] = Gen.chooseNum[T](numeric.zero, range)
  lazy val negative: Gen[T] = Gen.chooseNum[T](numeric.negate(range), numeric.zero)
  lazy val default: Gen[T] = Gen.chooseNum[T](numeric.negate(range), range)
}

object SignGenerator {
  implicit def signGeneratorDefaultCaller[T : Numeric: Choose]: DefaultCaller[T, SignGenerator[T]] =
    new DefaultCaller[T, SignGenerator[T]] {
      override def apply(callee: SignGenerator[T]): Gen[T] = callee.default
  }
}
