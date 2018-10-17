---
layout: docs
title: Generators
---

## {{page.title}}
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

#### Size API
All basic generators conform to the SizeApi which defines 5 default generation sizes:

```scala
Generate.alpha.tiny       // Smallest set of data
Generate.alpha.short      // Data is still readable but larger than tiny.
Generate.alpha.default    // If you don't know what to use, use this.
Generate.alpha.big        // Data is big.  Not human readable.
Generate.alpha.huge       // Largest possible data generation.
```
