---
layout: home
section: "home"
title: "Home"
position: 1
technologies:
 - first: ["Scala", "TestCharged library is completely written in Scala."]
 - second: ["ScalaTest", "Some of the helpers provided by TestCharged assume the use of ScalaTest."]
 - third: ["ScalaCheck", "The generators of TestCharged are based on the fantastic ScalaCheck library."]
---

# TestCharged
[![Travis (.org)](https://img.shields.io/travis/fulrich/test-charged.svg?style=flat-square)](https://travis-ci.org/fulrich/test-charged)
[![Codecov](https://img.shields.io/codecov/c/github/fulrich/test-charged.svg?style=flat-square)](https://codecov.io/gh/fulrich/test-charged)
[![Scala Versions](https://img.shields.io/badge/scala-2.11%20%7C%202.12-blue.svg?style=flat-square)](https://github.com/fulrich/TestCharged/blob/455d73f549c5edd0d71d2d13748cd8c458483d20/build.sbt#L3)

[![Maven Central](https://img.shields.io/maven-central/v/com.github.fulrich/test-charged_2.12.svg?style=flat-square)](https://search.maven.org/artifact/com.github.fulrich/test-charged_2.12/0.1.1/jar)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.github.fulrich/test-charged_2.12.svg?style=flat-square)](https://oss.sonatype.org/content/repositories/snapshots/com/github/fulrich/test-charged_2.12/)

## Overview

A small library with helpers for generating test data through a simple DSL.

You can super charge water.  You should also super charge your tests.

## Setup

The currently released build should be shown on the badges at the top of this page.

Simply add that dependency to your SBT file:

```scala 
libraryDependencies += "com.github.fulrich" %% "test-charged" % "0.1.5"
```

Our SNAPSHOT version is also shown at the badges on the top.  
To use the newest SHAPSHOT you must include the Sonatype resolver and then add the dependency.

```scala
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.github.fulrich" %% "test-charged" % "0.1.6-SNAPSHOT" % "test"
```
