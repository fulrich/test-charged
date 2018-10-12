# TestCharged
[![Scala Versions](https://img.shields.io/badge/scala-2.11%20%7C%202.12-blue.svg?style=flat-square)](https://github.com/fulrich/TestCharged/blob/455d73f549c5edd0d71d2d13748cd8c458483d20/build.sbt#L3)

[![Travis (.org)](https://img.shields.io/travis/fulrich/TestCharged.svg?style=flat-square)](https://travis-ci.org/fulrich/TestCharged)
[![Codacy grade](https://img.shields.io/codacy/grade/fc8c140e94324c47bfe42f2569e0f96f.svg?style=flat-square)](https://app.codacy.com/project/fulrich/TestCharged/dashboard)
[![Codacy coverage](https://img.shields.io/codacy/coverage/fc8c140e94324c47bfe42f2569e0f96f.svg?style=flat-square)](https://app.codacy.com/project/fulrich/TestCharged/dashboard)

[![Maven Central](https://img.shields.io/maven-central/v/com.github.fulrich/test-charged_2.12.svg?style=flat-square)](https://search.maven.org/artifact/com.github.fulrich/test-charged_2.12/0.1.1/jar)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.github.fulrich/test-charged_2.12.svg?style=flat-square)](https://oss.sonatype.org/content/repositories/snapshots/com/github/fulrich/test-charged_2.12/)

A small library with helpers for generating test data through a simple DSL.

You can super charge water.  You should also super charge your tests.

## Setup
The currently released build should be shown on the badges at the top of this README.
Simply add that dependency to your SBT file:

`libraryDependencies += "com.github.fulrich" % "test-charged_2.12" % "0.1.1"`

Our SNAPSHOT version is also shown at the badges on the top.  
To use the newest SHAPSHOT you must include the Sonatype resolver and then add the dependency.

```scala
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.github.fulrich" %% "test-charged" % "0.1.1-SNAPSHOT" % "test"
```

## Generators
ScalaCheck is an amazing library that allows us to create property based checking. 
I love ScalaCheck but found I was often rewriting some common helpers.
They are now provided using TestCharged's generator package.

### Import
```scala
import com.github.fulrich.testcharged.generators._
```

### Concrete Values
I often found I wanted generated values for my tests because I did not want to care about the actual data. The TestCharged generator DSL allows you to do this quickly and easily from any ScalaCheck Gen object.

```scala
Generate.alpha.value               // String
Generate.alpha.option              // Option[String] - Could be Some or None
Generate.alpha.some                // Some(String) - Will always evaluate to Some
Generate.alpha.seq                 // Seq[String] - Length is arbitrary
Generate.alpha.nonEmptySeq         // Seq[String] - Will never be empty
Generate.alpha.seqOf(size = 3)     // Seq[String] - Will be of size 3
``` 

This same DSL can be used to transform a simple `Gen[String]` into more complex generators:

```scala
Generate.alpha.gen.option              // Gen[Option[String]] - Generated option could be Some or None
Generate.alpha.gen.some                // Gen[Some(String)] - Generated option will always evaluate to Some
Generate.alpha.gen.seq                 // Gen[Seq[String]] - Generated sequence's length is arbitrary
Generate.alpha.gen.nonEmptySeq         // Gen[Seq[String]] - Generated sequence will never be empty
Generate.alpha.gen.seqOf(size = 3)     // Gen[Seq[String]] - Generated sequence will be of size 3
```

### Provided Generators
There are many common use cases for generated data.  TestCharged attempts to provide a number of them.
You can access these generators through the Generate object which is part of the generators package.

#### Basic Generators
All basic generators conform to the SizeApi which defines 5 default generation sizes:

```scala
Generate.alpha.tiny       // Smallest set of data
Generate.alpha.short      // Data is still readable but larger than tiny.
Generate.alpha.default    // If you don't know what to use, use this.
Generate.alpha.big        // Data is big.  Not human readable.
Generate.alpha.huge       // Largest possible data generation.
```

##### String
Below are the provided basic string generators.

| Name          | Description                                            | Code                    |
| ------------- | ------------------------------------------------------ | ----------------------- |
| Alpha         | Generates string that only include letters             | `Generate.alpha`        |
| Alpha Numeric | Generates string that only includes letters or digits. | `Generate.alphaNumeric` |

An example of generating an alpha only string:
```scala
Generate.alpha.default.value
```

##### Numeric
Numeric generators provide an extra ability to choose the sign of the generated value.
The following methods are provided to do so:

```scala
Generate.int.default.positive     // Generates a positive numeric value.
Generate.int.default.negative     // Generates a negative numeric value.
Generate.int.default.default      // The generated value could be positive or negative.
```

Below are the provided basic numeric generators.

| Name   | Description               | Code              |
| ------ | ------------------------- | ----------------- |
| Short  | Generates short values.   | `Generate.short`  |
| Int    | Generates integer values. | `Generate.int`    |
| Long   | Generates long values.    | `Generate.long`   |
| Double | Generates double values.  | `Generate.double` |
| Float  | Generates float values.   | `Generate.float`  |

An example of generating a positive integer value:
```scala
Generate.int.default.positive.value
```

##### Other
There are a number of other generators that exists to generate realistic data quickly and easily.

| Name    | Description                        | Generators            |
| ------- | ---------------------------------- | --------------------- |
| country | Used to generate a random country. | `code, name, default` |
