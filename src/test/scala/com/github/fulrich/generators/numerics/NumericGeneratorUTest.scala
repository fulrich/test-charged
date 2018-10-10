package com.github.fulrich.generators.numerics

import org.scalatest.{FunSuite, Matchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks


class NumericGeneratorUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {
  object TestIntGenerators extends NumericGenerator[Int] {
    override val Minimum: Int = 0
    override val TinyMaximum: Int = 5
    override val ShortMaximum: Int = 10
    override val DefaultMaximum: Int = 15
    override val BigMaximum: Int = 20
    override val HugeMaximum: Int = 25
  }

  test("A numeric generator can create values of the specific type between a range") {
    forAll(TestIntGenerators(5, 50)) { generatedInt =>
      generatedInt should be >= 5
      generatedInt should be <= 50
    }
  }

  test("An exception should be thrown if a minimum is larger than the given maximum") {
    the [IllegalArgumentException] thrownBy {
      TestIntGenerators(55, 50)
    } should have message "requirement failed: Your minimum value (55) must be less than your maximum (50)."
  }


  test("The tiny size should create a SignGenerator with the TinyMaximum as the range") {
    TestIntGenerators.tiny.range shouldBe 5
  }

  test("The short size should create a SignGenerator with the ShortMaximum as the range") {
    TestIntGenerators.short.range shouldBe 10
  }

  test("The default size should create a SignGenerator with the DefaultMaximum as the range") {
    TestIntGenerators.default.range shouldBe 15
  }

  test("The big size should create a SignGenerator with the BigMaximum as the range") {
    TestIntGenerators.big.range shouldBe 20
  }

  test("The huge size should create a SignGenerator with the HugeMaximum as the range") {
    TestIntGenerators.huge.range shouldBe 25
  }
}
