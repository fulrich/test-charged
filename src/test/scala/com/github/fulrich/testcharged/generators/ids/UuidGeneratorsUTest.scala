package com.github.fulrich.testcharged.generators.ids

import org.scalatest.{FunSuite, Matchers, OptionValues}

class UuidGeneratorsUTest extends FunSuite with Matchers with OptionValues{
  test("Single UUID generation") {
    val generatedUUID = UuidGenerators.uuid.sample
  
      generatedUUID should not be empty
      generatedUUID.value.toString should include("-")
  }
}
