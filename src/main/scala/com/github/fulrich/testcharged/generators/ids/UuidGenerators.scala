package com.github.fulrich.testcharged.generators.ids

import java.util.UUID

import org.scalacheck.Gen

object UuidGenerators {
  val uuid: Gen[UUID] = Gen.uuid
}
