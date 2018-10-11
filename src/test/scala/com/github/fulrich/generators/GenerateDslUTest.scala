package com.github.fulrich.generators

import com.github.fulrich.generators.strings.AlphaGenerators
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class GenerateDslUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {
  val ConstantGeneratedString: String = "Test"
  val generator: Gen[String] = Gen.const(ConstantGeneratedString)

  test("Can take a base generator and use the DSL to grab multiple concrete value types") {
    generator.value shouldBe ConstantGeneratedString
    generator.option should (be(Option(ConstantGeneratedString)) or be(None))
    generator.some shouldBe Some(ConstantGeneratedString)
    generator.seqOf(3) shouldBe Seq(ConstantGeneratedString, ConstantGeneratedString, ConstantGeneratedString)
    generator.seq should contain only (ConstantGeneratedString)
    generator.nonEmptySeq.nonEmpty
  }
  
  test("If a Gen is required the .default called can be skipped") {
    forAll(Generate.alpha) { generatedString =>
      generatedString.length should be >= AlphaGenerators.ShortMaximum
      generatedString.length should be <= AlphaGenerators.DefaultMaximum
    }
  }

  test("If using the default size do not need to use the .default method") {
    val generatedString = Generate.alpha.value

    generatedString.length should be >= AlphaGenerators.ShortMaximum
    generatedString.length should be <= AlphaGenerators.DefaultMaximum
  }
}
