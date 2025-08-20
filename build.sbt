import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val instances = (project in file("."))
  .settings(name := "instances")
  .aggregate(
    catsInstances,
    scalaCheckInstances,
  )

lazy val catsInstances = (project in file("cats-instances"))
  .settings(name := "cats-instances")
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

lazy val catsInstancesTuple = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/tuple"))
  .settings(name := "cats-instances-tuple")
  .settings(crossDependencies(typelevel.cats))

lazy val catsInstancesClass = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/class"))
  .settings(name := "cats-instances-class")
  .settings(crossDependencies(typelevel.cats))

lazy val catsInstancesTime = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/time"))
  .settings(name := "cats-instances-time")
  .settings(crossDependencies(typelevel.cats))

lazy val catsInstancesCirce = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/circe"))
  .settings(name := "cats-instances-circe")
  .settings(crossDependencies(circe))

lazy val catsInstancesScodecBits = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/scodec-bits"))
  .settings(name := "cats-instances-scodec-bits")
  .settings(crossDependencies(
    typelevel.cats,
    scodec.bits
  ))

lazy val catsInstancesScalaCheck = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("cats-instances/scalacheck"))
  .settings(name := "cats-instances-scalacheck")
  .settings(crossDependencies(
    typelevel.cats,
    peknight.ext.scalaCheck
  ))

lazy val scalaCheckInstances = (project in file("scalacheck-instances"))
  .settings(name := "scalacheck-instances")
  .aggregate(
    scalaCheckInstancesCats.jvm,
    scalaCheckInstancesCats.js,
  )

lazy val scalaCheckInstancesCats = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("scalacheck-instances/cats"))
  .dependsOn(catsInstancesScalaCheck)
  .settings(name := "scalacheck-instances-cats")
  .settings(crossTestDependencies(typelevel.cats.laws))
