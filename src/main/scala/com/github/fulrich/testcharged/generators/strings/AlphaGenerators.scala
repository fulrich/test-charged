package com.github.fulrich.testcharged.generators.strings

import com.github.fulrich.testcharged.generators.DefaultSizeGenerator
import org.scalacheck.Gen


object AlphaGenerators extends DefaultSizeGenerator[String] {
  override protected def generate(minimum: Long, maximum: Long): Gen[String] = for {
    size <- Gen.chooseNum(minimum, maximum)
    generatedString <- Gen.listOfN(size.toInt, Gen.alphaChar)
  } yield generatedString.mkString
}
