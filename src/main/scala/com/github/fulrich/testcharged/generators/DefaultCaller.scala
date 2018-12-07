package com.github.fulrich.testcharged.generators

import org.scalacheck.Gen


trait DefaultCaller[A, B] {
  def callDefault(callee: B): Gen[A]
}
