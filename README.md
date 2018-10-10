# TestCharged
A small library with helpers for generating test data through a simple DSL.

You can super charge water.  You should also super charge your tests.

## Setup
Currently TestCharged is only on the Sonatype SNAPSHOT server. 
Add the following line to your build.sbt to add the resolver:

`resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"`

You can then add the TestCharged dependency to your project:

`"com.github.fulrich" %% "test-charged" % "0.1.1-SNAPSHOT" % "test"`

## Generators
ScalaCheck is an amazing library that allows us to create property based checking. 
I love ScalaCheck but found I was often rewriting some common helpers.
They are now provided using TestCharged's generator package.

### Import
```scala
import com.github.fulrich.generators._
```

### Concrete Values
I often found I wanted generated values for my tests because I didn't want to care about the actual data. The TestCharged generator DSL allows you to do this quickly and easily from any ScalaCheck Gen object.

```scala
Gen.alphaStr.value               // String
Gen.alphaStr.option              // Option[String] - Could be Some or None
Gen.alphaStr.some                // Some(String) - Will always evaluate to Some
Gen.alphaStr.seq                 // Seq[String] - Length is arbitrary
Gen.alphaStr.nonEmptySeq         // Seq[String] - Will never be empty
Gen.alphaStr.seqOf(size = 3)     // Seq[String] - Will be of size 3
``` 

This same DSL can be used to transform a simple Gen[String] into more complex generators:

```scala
Gen.alphaStr.gen.option              // Gen[Option[String]] - Generated option could be Some or None
Gen.alphaStr.gen.some                // Gen[Some(String)] - Generated option will always evaluate to Some
Gen.alphaStr.gen.seq                 // Gen[Seq[String]] - Generated sequence's length is arbitrary
Gen.alphaStr.gen.nonEmptySeq         // Gen[Seq[String]] - Generated sequence will never be empty
Gen.alphaStr.gen.seqOf(size = 3)     // Gen[Seq[String]] - Generated sequence will be of size 3
```

### Provided Generators
There are many common use cases for generated data.  TestCharged attempts to provide a number of them.
You can access these generators through the Generate object which is part of the generators package.

#### Basic Generators
All basic generators conform to the SizeApi which defines 5 default generation sizes:

* tiny - Smallest set of data.
* short - Data is still readable but larger than tiny.
* default - If you don't know what to use, use this.
* big - Data is big.  Not human readable.
* huge - Largest possible data generation.

##### String
Below are the provided basic string generators.

Name | Description | Code
---- | ----------- | ----
Alpha | Generates string that only include letters | `Generate.alpha`
Alpha Numeric | Generates string that only includes letters or digits. | `Generate.alphaNumeric`

An example of generating an alpha only string:
```scala
Generate.alpha.default.value
```

##### Numeric
Numeric generators provide an extra ability to choose the sign of the generated value.
The following methods are provided to do so:

* positive - Generates a positive numeric value.
* negative - Generates a negative numeric value.
* default - The generated value could be positive or negative.

Below are the provided basic numeric generators.

Name | Description | Code
---- | ----------- | ----
short | Generates Short values. | `Generate.short`
int | Generates Integer values. | `Generate.int`
long | Generates Long values. | `Generate.long`
double | Generates Double values. | `Generate.double`
float | Generates Float values. | `Generate.float`

An example of generating a positive integer value:
```scala
Generate.int.default.positive.value
```

##### Other
There are a number of other generators that exists to generate realistic data quickly and easily.

Name | Description | Methods
---- | ----------- | ----
country | Used to generate a random country. | `code, name, default`

