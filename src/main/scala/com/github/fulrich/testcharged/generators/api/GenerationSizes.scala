package com.github.fulrich.testcharged.generators.api


trait GenerationSizes[T] {
  val Minimum: T
  val TinyMaximum: T
  val ShortMaximum: T
  val DefaultMaximum: T
  val BigMaximum: T
  val HugeMaximum: T
}
