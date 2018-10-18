package com.github.fulrich.testcharged.generators.locations

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class CityGeneratorsUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {

  test("All city names generated should be alpha only and start with a capital") {
    forAll(CityGenerators.default) { generatedCity =>
      CityGenerators.CityList should contain (generatedCity)
    }
  }
}
