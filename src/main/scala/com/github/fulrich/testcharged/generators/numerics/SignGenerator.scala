package com.github.fulrich.testcharged.generators.numerics

import com.github.fulrich.testcharged.generators.DefaultCaller
import com.github.fulrich.testcharged.generators.api.DefaultApi
import org.scalacheck.Gen
import org.scalacheck.Gen.Choose


case class SignGenerator[T : Choose](range: T)(implicit numeric: Numeric[T]) extends DefaultApi[T] {
  lazy val positive: Gen[T] = Gen.chooseNum[T](numeric.zero, range)
  lazy val negative: Gen[T] = Gen.chooseNum[T](numeric.negate(range), numeric.zero)
  override lazy val default: Gen[T] = Gen.chooseNum[T](numeric.negate(range), range)
}

object SignGenerator {
  implicit def signGeneratorDefaultCaller[T : Numeric: Choose]: DefaultCaller[T, SignGenerator[T]] =
    new DefaultCaller[T, SignGenerator[T]] {
      override def callDefault(callee: SignGenerator[T]): Gen[T] = callee.default
  }
}
