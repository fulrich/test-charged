package com.github.fulrich.testcharged.generators

import com.github.fulrich.testcharged.generators.numerics.{NumericGenerator, SignGenerator}
import org.scalacheck.Gen

import scala.language.implicitConversions


trait GenerateDsl {
  implicit class GeneratorHelper[T](private val generator: Gen[T]) {
    val gen = new ExtendedGeneratorsHelper[T](generator)

    def value: T = generator.sample match {
      case Some(value) => value
      case None => throw new IllegalArgumentException("Unable to generate the requested data.")
    }

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

  implicit def defaultGeneratorUseDefault[A](anySizeApi: DefaultSizeGenerator[A]): Gen[A] = anySizeApi.default
  implicit def defaultGeneratorUseDefaultHelper[A](anySizeApi: DefaultSizeGenerator[A]): GeneratorHelper[A] =
    new GeneratorHelper(anySizeApi.default)

  implicit def signGeneratorUseDefault[A](signGenerator: SignGenerator[A]): Gen[A] = signGenerator.default
  implicit def numericGeneratorUseDefault[A](numericGenerator: NumericGenerator[A]): Gen[A] = numericGenerator.default
  implicit def numericGeneratorUseDefaultHelper[A](signGenerator: NumericGenerator[A]): GeneratorHelper[A] =
    new GeneratorHelper(signGenerator.default.default)
}
