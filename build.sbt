import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val instances = (project in file("."))
  .aggregate(
    catsInstances,
    scalaCheckInstances,
  )
  .settings(
    name := "instances",
  )

lazy val catsInstances = (project in file("cats-instances"))
  .aggregate(
    catsInstancesTuple.jvm,
    catsInstancesTuple.js,
    catsInstancesTuple.native,
    catsInstancesClass.jvm,
    catsInstancesClass.js,
    catsInstancesClass.native,
    catsInstancesTime.jvm,
    catsInstancesTime.js,
    catsInstancesTime.native,
    catsInstancesCirce.jvm,
    catsInstancesCirce.js,
    catsInstancesCirce.native,
    catsInstancesScodecBits.jvm,
    catsInstancesScodecBits.js,
    catsInstancesScodecBits.native,
    catsInstancesScalaCheck.jvm,
    catsInstancesScalaCheck.js,
    catsInstancesScalaCheck.native,
  )
  .settings(
    name := "cats-instances",
  )

lazy val catsInstancesTuple = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/tuple"))
  .settings(crossDependencies(typelevel.cats))
  .settings(
    name := "cats-instances-tuple",
  )

lazy val catsInstancesClass = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/class"))
  .settings(crossDependencies(typelevel.cats))
  .settings(
    name := "cats-instances-class",
  )

lazy val catsInstancesTime = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/time"))
  .settings(crossDependencies(typelevel.cats))
  .settings(
    name := "cats-instances-time",
  )

lazy val catsInstancesCirce = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/circe"))
  .settings(crossDependencies(circe))
  .settings(
    name := "cats-instances-circe",
  )

lazy val catsInstancesScodecBits = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/scodec-bits"))
  .settings(crossDependencies(
    typelevel.cats,
    scodec.bits
  ))
  .settings(
    name := "cats-instances-scodec-bits",
  )

lazy val catsInstancesScalaCheck = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/scalacheck"))
  .settings(crossDependencies(
    typelevel.cats,
    peknight.ext.scalaCheck
  ))
  .settings(
    name := "cats-instances-scalacheck",
  )

lazy val scalaCheckInstances = (project in file("scalacheck-instances"))
  .aggregate(
    scalaCheckInstancesCats.jvm,
    scalaCheckInstancesCats.js,
  )
  .settings(
    name := "scalacheck-instances",
  )

lazy val scalaCheckInstancesCats = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("scalacheck-instances/cats"))
  .dependsOn(catsInstancesScalaCheck)
  .settings(crossTestDependencies(typelevel.cats.laws))
  .settings(
    name := "scalacheck-instances-cats",
  )
