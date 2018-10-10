package com.makkornall.generators

import org.scalacheck.Gen
import org.scalatest.{FunSuite, Matchers}


class GenerateDslUTest extends FunSuite with Matchers {
  val generator: Gen[String] = Gen.const("Test")

  test("Can take a base generator and use the DSL to grab multiple concrete value types") {
    generator.value shouldBe "Test"
    generator.option shouldBe Option("Test")
    generator.some shouldBe Some("Test")
    generator.seqOf(3) shouldBe Seq("Test", "Test", "Test")
    generator.seq should contain only ("Test")
    generator.nonEmptySeq.nonEmpty
  }
}
