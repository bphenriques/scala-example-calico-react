package example.components

import example.components.visxcomponent.*
import example.model.TreeNode
import slinky.core.{FunctionalComponent, KeyAddingStage}
import slinky.core.facade.ReactElement
import slinky.web.svg.*

import example.facade.visx

// Based on the example: https://airbnb.io/visx/trees
object TreeView {
  case class Props(tree: TreeNode)

  val peach = "#fd9b93"
  val pink  = "#fe6e9e"

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { props =>
    val targetWidth  = "500"
    val targetHeight = "500"
    val data         = visx.hierarchy[TreeNode](props.tree)

    svg(width := targetWidth, height := targetHeight)(
      LinearGradient(LinearGradient.Props("lg", peach, pink)),
      rect(width := targetWidth, height := targetHeight, rx := 14, fill := pink),
      Tree(
        Tree.Props(
          root = data,
          size = Array(400, 400),
          children = { tree =>
            Group(Group.Props(top = 25, left = 25))(
              tree
                .links()
                .zipWithIndex
                .map { case (link, i) =>
                  LinkHorizontalStep(LinkHorizontalStep.Props(data = link))(
                    fill        := "none",
                    strokeWidth := "1",
                    stroke      := "pink",
                  ).withKey(s"link-$i")
                }
                .toSeq,
              tree
                .descendants()
                .zipWithIndex
                .map { case (node, i) =>
                  Node.component(Node.Props(node)).withKey(s"node-$i")
                }
                .toSeq,
            )
          },
        ),
      ),
    )
  }

  def treeView(tree: TreeNode): KeyAddingStage = component(Props(tree))
}

object Node {
  case class Props(node: visx.HierarchyPointNode[TreeNode])

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { props =>
    Group(Group.Props(top = props.node.x, left = props.node.y))(
      circle(r := 12, fill := "#999999"),
      text(
        dy         := ".33em",
        fontSize   := 9,
        fontFamily := "Arial",
        textAnchor := "middle",
        style(pointerEvents := "none", fill := "plum"),
      )(
        props.node.data.name,
      ),
    )
  }
}
