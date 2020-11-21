name := """play-java-seed"""
organization := "de.pge.play"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.3"

testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

libraryDependencies ++= Seq(
  guice,
  "org.mongodb" % "mongo-java-driver" % "3.12.0",
  "dev.morphia.morphia" % "core" % "1.5.8"
)

javacOptions ++= Seq(
  "-Xlint:unchecked",
  "-Xlint:deprecation",
  "-Werror"
)
