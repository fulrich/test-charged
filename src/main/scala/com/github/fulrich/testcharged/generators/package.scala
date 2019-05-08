package com.github.fulrich.testcharged

import com.github.fulrich.testcharged.generators.ids.IdGenerators
import com.github.fulrich.testcharged.generators.temporal.TemporalGenerators
import com.github.fulrich.testcharged.generators.locations.LocationGenerators
import com.github.fulrich.testcharged.generators.numerics.NumericGenerators
import com.github.fulrich.testcharged.generators.strings.StringGenerators


package object generators extends GenerateDsl {
  object Generate
    extends StringGenerators
    with NumericGenerators
    with LocationGenerators
    with TemporalGenerators
    with IdGenerators
}
