package com.github.fulrich.testcharged.generators

import org.scalactic.anyvals.PosInt
import org.scalatest.prop.GeneratorDrivenPropertyChecks


trait GeneratorTesting extends GeneratorDrivenPropertyChecks {
  private val MinimumSuccessfulRequired: PosInt = 100000

  implicit override val generatorDrivenConfig: PropertyCheckConfiguration = PropertyCheckConfiguration(
    minSuccessful = MinimumSuccessfulRequired
  )
}
