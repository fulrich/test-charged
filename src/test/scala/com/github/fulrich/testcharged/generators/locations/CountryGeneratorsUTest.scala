package com.github.fulrich.testcharged.generators.locations

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}


class CountryGeneratorsUTest extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {
  test("Can generate just a code of any country in the country list") {
    val allCountryCodes = CountryGenerators.CountryList.map(_.code)

    forAll(CountryGenerators.code) { countryCode =>
      allCountryCodes should contain (countryCode)
    }
  }

  test("Can generate just a name of any country in the country list") {
    val allCountryNames = CountryGenerators.CountryList.map(_.name)

    forAll(CountryGenerators.name) { countryName =>
      allCountryNames should contain (countryName)
    }
  }

  test("Can generate a full country object using the country generators") {
    forAll(CountryGenerators.default) { country =>
      CountryGenerators.CountryList should contain (country)
    }
  }
}
