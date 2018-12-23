package com.github.fulrich.testcharged.generators.temporal

import com.github.fulrich.testcharged.generators.GeneratorTesting
import org.scalatest.{FunSuite, Matchers}


trait TemporalTesting extends FunSuite with Matchers with GeneratorTesting with NowDsl with TemporalOrdering {
  def withinRange[A : Ordering](after: A, before: A)(generatedDate: A): Unit = {
    generatedDate should be >= after
    generatedDate should be <= before
  }
}
