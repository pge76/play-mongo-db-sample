name := """play-mongo-db-sample"""
organization := "de.pge.play"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.3"

testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

libraryDependencies ++= Seq(
  guice,
  "org.mongodb" % "mongo-java-driver" % "3.12.0",
  "dev.morphia.morphia" % "core" % "1.5.8",
  "com.adrianhurt" %% "play-bootstrap" % "1.6.1-P28-B4"
)

javacOptions ++= Seq(
  "-Xlint:unchecked",
  "-Xlint:deprecation",
  "-Werror"
)
