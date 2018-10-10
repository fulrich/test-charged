package com.makkornall

import com.makkornall.generators.numerics.NumericGenerators
import com.makkornall.generators.strings.StringGenerators


package object generators extends  GenerateDsl {
  object Generate
    extends StringGenerators
    with NumericGenerators
}
