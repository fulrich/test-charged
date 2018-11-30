package com.github.fulrich.testcharged.generators.api


trait SizeApi[T] {
  val tiny: T
  val small: T
  val default: T
  val large: T
  val huge: T
}
