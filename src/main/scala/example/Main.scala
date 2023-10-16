package example

import calico.*
import calico.html.io.{*, given}
import cats.effect.*
import example.components.TreeView.treeView
import example.helper.calicoreact.reactDiv
import fs2.dom.*
import example.model.TreeNode

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Resources {

  @js.native
  @JSImport("/javascript.svg", JSImport.Default)
  val reactLogo: String = js.native
}

object Main extends IOWebApp {

  val tree: TreeNode = TreeNode(
    "A",
    Array(
      TreeNode("A1", Array()),
      TreeNode("A2", Array()),
    ),
  )

  override def render: Resource[IO, HtmlElement[IO]] =
    div(
      cls := "App",
      div(
        cls := "App-header",
        img(src := Resources.reactLogo, cls := "App-logo", alt := "logo"),
        h1(cls  := "App-Title", "Welcome to React (with Scala.js!)"),
      ),
      p(
        cls := "App-intro",
        "To get started, edit ",
        code("App.scala"),
        " and save to reload.",
      ),
      div(
        idAttr := "react-tree",
      ),
      reactDiv("react-tree", IO(treeView(tree))),
    )
}
