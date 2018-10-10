package com.github.fulrich

import com.github.fulrich.generators.locations.LocationGenerators
import com.github.fulrich.generators.numerics.NumericGenerators
import com.github.fulrich.generators.strings.StringGenerators


package object generators extends  GenerateDsl {
  object Generate
    extends StringGenerators
    with NumericGenerators
    with LocationGenerators
}
