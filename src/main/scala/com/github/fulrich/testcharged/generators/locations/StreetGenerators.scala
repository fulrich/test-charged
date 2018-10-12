package com.github.fulrich.testcharged.generators.locations

import com.github.fulrich.testcharged.generators._
import org.scalacheck.Gen

import scala.io.Source


object StreetGenerators {
  private lazy val streetFile = "/generators/locations/streets.txt"
  private lazy val suffixesFile = "/generators/locations/street-suffixes.txt"

  lazy val Names: Seq[String] = Source.fromInputStream(getClass.getResourceAsStream(streetFile)).getLines.toVector
  lazy val Suffixes: Seq[String] = Source.fromInputStream(getClass.getResourceAsStream(suffixesFile)).getLines.toVector

  val MinimumStreetNumber = 1
  val MaximumStreetNumber = 9999


  val number: Gen[Int] = Generate.int(MinimumStreetNumber, MaximumStreetNumber)
  val name: Gen[String] = Gen.oneOf(Names)
  val suffix: Gen[String] = Gen.oneOf(Suffixes)

  val default: Gen[String] = for {
    generatedStreetNumber <- number
    generatedStreetName <- name
    generatedStreetSuffix <- suffix.gen.option
    streetSuffix = generatedStreetSuffix.map(" " + _).getOrElse("")
  } yield s"$generatedStreetNumber $generatedStreetName$streetSuffix"
}
