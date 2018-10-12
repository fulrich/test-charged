package com.github.fulrich.testcharged.generators.locations

import org.scalacheck.Gen

import scala.io.Source


object CountryGenerators {
  case class Country(code: String, name: String)

  private lazy val countryFile = "/generators/locations/countries.txt"
  private lazy val rawCountryList = Source.fromInputStream(getClass.getResourceAsStream(countryFile)).getLines.toVector

  val CountryList: Seq[Country] = rawCountryList.map { countryString =>
    val Array(code, name) = countryString.split('|')
    Country(code, name)
  }

  val default: Gen[Country] = Gen.oneOf(CountryList)
  val code: Gen[String] = default.map(_.code)
  val name: Gen[String] = default.map(_.name)
}
