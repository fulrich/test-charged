package com.github.fulrich.testcharged.generators.ids

import java.util.UUID

import com.github.fulrich.testcharged.generators.api.DefaultCaller
import org.scalacheck.Gen

class UuidGenerators {
  val default: Gen[UUID] = Gen.uuid
}

object UuidGenerators {
  def apply(): UuidGenerators = new UuidGenerators()
  
  implicit def uuidGeneratorDefaultCaller: DefaultCaller[UUID, UuidGenerators] =
    new DefaultCaller[UUID, UuidGenerators] {
      override def apply(callee: UuidGenerators): Gen[UUID] = callee.default
    }
}
