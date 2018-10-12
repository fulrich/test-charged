package com.github.fulrich.testcharged.generators.strings

import com.github.fulrich.testcharged.generators.DefaultSizeGenerator
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class StringGeneratorsUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {
  test("All String based generators conform to the standard size API") {
    testStringGenerator(AlphaGenerators)(_.isLetter)
    testStringGenerator(AlphaNumericGenerators)(character => character.isDigit || character.isLetter)
  }

  def testStringGenerator(generator: DefaultSizeGenerator[String])(checkCharacter: Char => Boolean): Unit = {
    testMaximumLargerThanMinimum(generator)

    testMinimumMaximum(generator, generator.ShortMaximum, generator.BigMaximum)(checkCharacter)
    testRangeGeneration(generator(generator.BigMaximum), generator.Minimum, generator.BigMaximum)(checkCharacter)

    testRangeGeneration(generator.tiny, generator.Minimum, generator.TinyMaximum)(checkCharacter)
    testRangeGeneration(generator.short, generator.TinyMaximum, generator.ShortMaximum)(checkCharacter)
    testRangeGeneration(generator.default, generator.ShortMaximum, generator.DefaultMaximum)(checkCharacter)
    testRangeGeneration(generator.big, generator.DefaultMaximum, generator.BigMaximum)(checkCharacter)
    testRangeGeneration(generator.huge, generator.BigMaximum, generator.HugeMaximum)(checkCharacter)
  }

  def testRangeGeneration(generator: Gen[String], minimum: Int, maximum: Int)(checkCharacter: Char => Boolean): Unit =
    forAll(generator) { generatedString =>
      generatedString.length should be >= minimum
      generatedString.length should be <= maximum

      generatedString.filter(checkCharacter).length shouldBe generatedString.length
    }

  def testMinimumMaximum(generator: DefaultSizeGenerator[String], minimum: Int, maximum: Int)
                        (checkCharacter: Char => Boolean): Unit =
    forAll(generator(minimum, maximum)) { generatedString =>
      generatedString.length should be >= minimum
      generatedString.length should be <= maximum

      generatedString.filter(checkCharacter).length shouldBe generatedString.length
    }

  def testMaximumLargerThanMinimum(generator: DefaultSizeGenerator[String]): Unit = {
    val minimum = generator.BigMaximum
    val maximum = generator.ShortMaximum
    val expected = s"requirement failed: Your minimum value ($minimum) must be less than your maximum ($maximum)."

    the[IllegalArgumentException] thrownBy generator(minimum, maximum) should have message expected
  }
}
