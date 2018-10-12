package com.github.fulrich.testcharged.generators.strings

import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class AlphaNumericGeneratorsUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {
  test("The AlphaNumericGenerators generate will only generate a string of letters or digits within the given size") {
    val minimumGenerator = Gen.chooseNum[Int](0, 5)
    val maximumGenerator = Gen.chooseNum[Int](10, 20)

    forAll(minimumGenerator, maximumGenerator) { (minimum, maximum) =>
      forAll(AlphaNumericGenerators(minimum, maximum)) { generatedString =>
        generatedString.length should be >= minimum
        generatedString.length should be <= maximum

        generatedString.filter(character => character.isLetter || character.isDigit).length shouldBe generatedString.length
      }
    }
  }
}
