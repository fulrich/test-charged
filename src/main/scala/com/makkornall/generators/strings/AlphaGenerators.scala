package com.makkornall.generators.strings

import com.makkornall.generators.DefaultSizeGenerator
import org.scalacheck.Gen


object AlphaGenerators extends DefaultSizeGenerator[String] {
  override protected def generate(minimum: Long, maximum: Long): Gen[String] = for {
    size <- Gen.chooseNum(minimum, maximum)
    generatedString <- Gen.listOfN(size.toInt, Gen.alphaChar)
  } yield generatedString.mkString
}
