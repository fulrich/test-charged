name := "GeneratorHelpers"
version := "0.1"
scalaVersion := "2.12.7"


val ScalacticVersion = "3.0.5"
val ScalaCheckVersion = "1.14.0"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % ScalaCheckVersion,
  "org.scalactic" %% "scalactic" % ScalacticVersion,
  "org.scalatest" %% "scalatest" % ScalacticVersion % "test",
)
