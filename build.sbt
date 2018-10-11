name := "Test Charged"
version := "0.1.2-SNAPSHOT"
crossScalaVersions := Seq("2.11.12", "2.12.7")


// POM Settings
organization := "com.github.fulrich"
homepage := Some(url("https://github.com/fulrich/testcharged"))
scmInfo := Some(ScmInfo(url("https://github.com/fulrich/testcharged"), "git@github.com:fulrich/testcharged.git"))
developers := List(
  Developer(
    "fulrich",
    "fulrich",
    "9284621+fulrich@users.noreply.github.com",
    url("https://github.com/fulrich")
  )
)
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
publishMavenStyle := true


// Dependencies
val ScalacticVersion = "3.0.5"
val ScalaCheckVersion = "1.14.0"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % ScalaCheckVersion,
  "org.scalactic" %% "scalactic" % ScalacticVersion,
  "org.scalatest" %% "scalatest" % ScalacticVersion % "test",
)


// Publishing
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
