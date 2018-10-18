package com.github.fulrich.testcharged.generators.locations

import org.scalacheck.Gen

import scala.io.Source


object CityGenerators {
  private lazy val cityFile = "/generators/locations/cities.txt"
  lazy val CityList: Seq[String] = Source.fromInputStream(getClass.getResourceAsStream(cityFile)).getLines.toVector

  val default: Gen[String] = Gen.oneOf(CityList)
}
