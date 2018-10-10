package com.makkornall.generators.numerics

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class SignGeneratorUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {

  test("For a given range the SignGenerator can generate values positive to the max of that range") {
    val signGenerator = new SignGenerator[Int](range = 50)

    forAll(signGenerator.positive) { generatedInt =>
      generatedInt should be >= 0
      generatedInt should be <= 50
    }
  }

  test("For a given range the SignGenerator can generate values negative to the minimum of that range") {
    val signGenerator = new SignGenerator[Int](range = 50)

    forAll(signGenerator.negative) { generatedInt =>
      generatedInt should be >= -50
      generatedInt should be <= 0
    }
  }

  test("For a given range the SignGenerator can generate values to the minimum or maximum of that range") {
    val signGenerator = new SignGenerator[Int](range = 50)

    forAll(signGenerator.default) { generatedInt =>
      generatedInt should be >= -50
      generatedInt should be <= 50
    }
  }
}
