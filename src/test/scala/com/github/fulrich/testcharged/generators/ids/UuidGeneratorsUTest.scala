package com.github.fulrich.testcharged.generators.ids

import com.github.fulrich.testcharged.generators._
import org.scalatest.{FunSuite, Matchers, OptionValues}

class UuidGeneratorsUTest extends FunSuite with Matchers with OptionValues {
  test("Single UUID generation") {
    val generatedUuid = Generate.uuid.value
    
    generatedUuid.toString should include("-")
  }
}
