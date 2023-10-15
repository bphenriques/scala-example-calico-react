import org.scalajs.linker.interface.ModuleSplitStyle


val calicoV = "0.2.1"

val scala3V = "3.3.1"

val slinkyV = "0.7.4+1-e3ba8c29"

val circeV = "0.14.6"

val fs2V = "3.9.2"

val scalaJsDomV = "2.2.0"

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / organization := "com.bphenriques"
ThisBuild / organizationName := "Bruno Henriques"
ThisBuild / startYear := Some(2023)
ThisBuild / developers := List(Developer("bphenriques", "Bruno Henriques", "bphenriques@outlook.com", url("https://github.com/bphenriques/")))

lazy val web = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := scala3V,
    javacOptions ++= Seq("-source", "21", "-target", "21"), // Ensures we are building using JDK 21
    scalaJSUseMainModuleInitializer := true,
    Compile / mainClass := Some("example.Main"),
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule).withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("example")))
    },

    libraryDependencies ++= List(
      "com.armanbilge" %%% "calico" % calicoV,
      "io.circe" %%% "circe-core" % circeV,
      "io.circe" %%% "circe-generic" % circeV,
      "io.circe" %%% "circe-parser" % circeV,
      "co.fs2" %%% "fs2-io" % fs2V,
      "org.scala-js" %%% "scalajs-dom" % scalaJsDomV,

      // FIXME: remove if possible
      "me.shadaj" %%% "slinky-web" % slinkyV,
      "me.shadaj" %%% "slinky-hot" % slinkyV,

      // No tests (yet) - trying things out
      //      "org.scalatest" %%% "scalatest" % "3.2.9" % Test
    )
  )
