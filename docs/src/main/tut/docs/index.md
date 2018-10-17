---
layout: docs
title: Quick Start
---

## {{page.title}}

To use TestCharged in an existing SBT project with Scala 2.11 or a later version, add the following dependency to your `build.sbt`. 
The most recent stable version of TestCharged can be seen on our badges [here](../index.html).


```scala 
libraryDependencies += "com.github.fulrich" %% "test-charged" % "0.1.1"
```

Our SNAPSHOT version is also shown on the badges [here](../index.html).
To use the newest SHAPSHOT you must include the Sonatype resolver and then add the dependency.

```scala
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.github.fulrich" %% "test-charged" % "0.1.1-SNAPSHOT" % "test"
```
