ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

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
    catsInstances,
    scalaCheckInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "instances",
  )

lazy val catsInstances = (project in file("cats-instances"))
  .aggregate(
    catsInstancesTuple.jvm,
    catsInstancesTuple.js,
    catsInstancesTime.jvm,
    catsInstancesTime.js,
    catsInstancesScalaCheck.jvm,
    catsInstancesScalaCheck.js,
  )
  .settings(commonSettings)
  .settings(
    name := "cats-instances",
  )

lazy val catsInstancesTuple = (crossProject(JSPlatform, JVMPlatform) in file("cats-instances/tuple"))
  .settings(commonSettings)
  .settings(
    name := "cats-instances-tuple",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % catsVersion,
    )
  )

lazy val catsInstancesTime = (crossProject(JSPlatform, JVMPlatform) in file("cats-instances/time"))
  .settings(commonSettings)
  .settings(
    name := "cats-instances-time",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % catsVersion,
    )
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

lazy val scalaCheckInstances = (project in file("scalacheck-instances"))
  .aggregate(
    scalaCheckInstancesCats.jvm,
    scalaCheckInstancesCats.js,
  )
  .settings(commonSettings)
  .settings(
    name := "scalacheck-instances",
  )

lazy val scalaCheckInstancesCats = (crossProject(JSPlatform, JVMPlatform) in file("scalacheck-instances/cats"))
  .dependsOn(catsInstancesScalaCheck)
  .settings(commonSettings)
  .settings(
    name := "scalacheck-instances-cats",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-laws" % catsVersion % Test,
    )
  )

val catsVersion = "2.10.0"
val scalaCheckVersion = "1.17.0"
