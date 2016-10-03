name := "scala-ecb-parser"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.10",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
  "org.typelevel" %% "cats" % "0.7.2",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.11" % "test"
)

