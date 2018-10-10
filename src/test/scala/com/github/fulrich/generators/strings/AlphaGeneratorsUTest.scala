package com.github.fulrich.generators.strings

import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class AlphaGeneratorsUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {

  test("The AlphaGenerators generate will only generate a string of letters within the given size") {
    val minimumGenerator = Gen.chooseNum[Int](0, 5)
    val maximumGenerator = Gen.chooseNum[Int](10, 20)

    forAll(minimumGenerator, maximumGenerator) { (minimum, maximum) =>
      forAll(AlphaGenerators(minimum, maximum)) { generatedString =>
        generatedString.length should be >= minimum
        generatedString.length should be <= maximum

        generatedString.filter(_.isLetter).length shouldBe generatedString.length
      }
    }
  }
}
