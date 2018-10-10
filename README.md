# TestCharged
A small library with helpers for generating test data through a simple DSL.
You can super charge water.  You should also super charge your tests.

## Generators
ScalaCheck is an amazing library that allows us to create property based checking. I love ScalaCheck but found I was often rewriting some common helpers.  They are now provided using TestCharged's generator package.

#### Import
```scala
import com.github.fulrich.generators._
```

#### Concrete Values
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
