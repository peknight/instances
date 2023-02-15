ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

ThisBuild / organization := "com.peknight"

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-Xfatal-warnings",
    "-language:strictEquality",
    "-Xmax-inlines:64"
  ),
)

lazy val instances = (project in file("."))
  .aggregate(
    catsInstancesScalaCheck.jvm,
    catsInstancesScalaCheck.js
  )
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings)
  .settings(
    name := "instances",
  )

lazy val catsInstancesScalaCheck = (crossProject(JSPlatform, JVMPlatform) in file("cats-instances/scalacheck"))
  .settings(commonSettings)
  .settings(
    name := "cats-instances-scalacheck",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % catsVersion,
      "org.scalacheck" %%% "scalacheck" % scalaCheckVersion,
    )
  )

val catsVersion = "2.9.0"
val scalaCheckVersion = "1.17.0"
