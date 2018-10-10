package com.makkornall.generators.strings

import com.makkornall.generators.DefaultSizeGenerator


trait StringGenerators {
  val alpha: DefaultSizeGenerator[String] = AlphaGenerators
  val alphaNumeric: DefaultSizeGenerator[String] = AlphaNumericGenerators
}
