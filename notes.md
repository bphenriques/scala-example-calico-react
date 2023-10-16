Minor notes that serve as reference, may not do anything with it.

###

Scala3 does not work very well on my machine :( IntelliJ and Codium does not work well. Metals is the latest but does
support 3.3.1)

### Calico
from:
```scala
    div(
      cls := "App",
      ...
    )
```

to:
```scala
    div(cls := "App", ...)(
      ...
    )
```

Reason: Visual distinction between attributes and child element.


### ScalablyTyped

As reference, I started with writing by hand to learn how it works. Another reason is that `visx` leads to a StackOverflow when transpiling.

```
    "@types/react-dom": "^18.2.13",
```

```
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta43+4-ae10c353-SNAPSHOT")
```

```
  .enablePlugins(ScalaJSPlugin, ScalablyTypedConverterExternalNpmPlugin)
  .settings(
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule).withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("example")))
    },

    // ScalaJSConverter
    externalNpm := {
      baseDirectory.value / "web"
    },
    stOutputPackage := "example.components.js",
    stIgnore ++= List(
      "csstype", // react dependency that we can easily ignore
      "@visx/gradient",
      "@visx/group",
      "@visx/hierarchy",
      "@visx/responsive",
      "@visx/shape"
    ),

```
