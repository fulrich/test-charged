package com.github.fulrich.testcharged.generators.numerics

import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class NumericGeneratorsUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks{

  test("All Numeric based generators conform to the NumericGenerator API") {
    testNumericGenerator(ShortGenerators)
    testNumericGenerator(IntGenerators)
    testNumericGenerator(LongGenerators)
    testNumericGenerator(FloatGenerators)
    testNumericGenerator(DoubleGenerators)
  }

  def testNumericGenerator[A : Numeric : Ordering](numericGenerator: NumericGenerator[A]): Unit = {
    testMinimumMaximum(numericGenerator, numericGenerator.ShortMaximum, numericGenerator.BigMaximum)
    testRangeGeneration(numericGenerator.tiny, numericGenerator.TinyMaximum)
    testRangeGeneration(numericGenerator.short, numericGenerator.ShortMaximum)
    testRangeGeneration(numericGenerator.default, numericGenerator.DefaultMaximum)
    testRangeGeneration(numericGenerator.big, numericGenerator.BigMaximum)
    testRangeGeneration(numericGenerator.huge, numericGenerator.HugeMaximum)
  }

  def testRangeGeneration[A : Ordering](generator: Gen[A], range: A)(implicit numeric: Numeric[A]): Unit =
    forAll(generator) { generatedValue =>
      generatedValue should be >= numeric.negate(range)
      generatedValue should be <= range
    }

  def testMinimumMaximum[A: Numeric : Ordering](generator: NumericGenerator[A], minimum: A, maximum: A): Unit = {
    forAll(generator(minimum, maximum)) { generatedValue =>
      generatedValue should be >= minimum
      generatedValue should be <= maximum
    }
  }
}
