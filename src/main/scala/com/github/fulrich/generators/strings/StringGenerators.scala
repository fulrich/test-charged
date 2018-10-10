package com.github.fulrich.generators.strings

import com.github.fulrich.generators.DefaultSizeGenerator


trait StringGenerators {
  val alpha: DefaultSizeGenerator[String] = AlphaGenerators
  val alphaNumeric: DefaultSizeGenerator[String] = AlphaNumericGenerators
}
