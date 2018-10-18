package com.github.fulrich.testcharged.generators.api

import org.scalacheck.Gen


trait DefaultApi[A] {
  def default: Gen[A]
}
