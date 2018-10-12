package com.github.fulrich.testcharged.generators.strings

import com.github.fulrich.testcharged.generators.DefaultSizeGenerator


trait StringGenerators {
  val alpha: DefaultSizeGenerator[String] = AlphaGenerators
  val alphaNumeric: DefaultSizeGenerator[String] = AlphaNumericGenerators
}
