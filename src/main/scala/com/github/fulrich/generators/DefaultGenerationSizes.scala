package com.github.fulrich.generators

import com.github.fulrich.generators.api.GenerationSizes


trait DefaultGenerationSizes extends GenerationSizes {
  val Minimum: Int = 0
  val TinyMaximum: Int = 8
  val ShortMaximum: Int = 16
  val DefaultMaximum: Int = 64
  val BigMaximum: Int = 512
  val HugeMaximum: Int = 2048
}
