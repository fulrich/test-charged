package com.github.fulrich.generators

import org.scalacheck.Gen


trait GenerateDsl {
  implicit class GeneratorHelper[T](private val generator: Gen[T]) {
    val gen = new ExtendedGeneratorsHelper[T](generator)

    def value: T = generator.sample.get
    def some: Option[T] = gen.some.value
    def option: Option[T] = gen.option.value
    def seq: Seq[T] = gen.seq.value
    def seqOf(size: Int): Seq[T] = gen.seq(size).value
    def nonEmptySeq: Seq[T] = gen.nonEmptySeq.value
  }

  class ExtendedGeneratorsHelper[T](private val generator: Gen[T]) {
    def some: Gen[Option[T]] = Gen.some(generator)
    def option: Gen[Option[T]] = Gen.option(generator)
    def seq: Gen[Seq[T]] = Gen.listOf(generator)
    def seq(size: Int): Gen[Seq[T]] = Gen.listOfN(size, generator)
    def nonEmptySeq: Gen[Seq[T]] = Gen.nonEmptyListOf(generator)
  }
}
