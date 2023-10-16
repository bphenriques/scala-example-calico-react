package example.components

import example.facade.visx
import example.model.TreeNode
import slinky.core.facade.ReactElement
import slinky.core.{ExternalComponent, ExternalComponentWithAttributes}
import slinky.web.svg.a

object visxcomponent {

  object LinearGradient extends ExternalComponent {
    case class Props(id: String, from: String, to: String)

    override val component = visx.LinearGradient
  }

  object Tree extends ExternalComponent {

    case class Props(
      root: visx.HierarchyPointNode[TreeNode],
      size: Array[Int],
      children: visx.HierarchyPointNode[TreeNode] => ReactElement,
    )

    override val component = visx.Tree
  }

  object Group extends ExternalComponent {

    case class Props(top: Int, left: Int)

    override val component = visx.Group
  }

  object LinkHorizontal extends ExternalComponentWithAttributes[a.tag.type] {

    case class Props(data: visx.HierarchyPointLink[TreeNode])

    override val component = visx.LinkHorizontal
  }

  object LinkHorizontalStep extends ExternalComponentWithAttributes[a.tag.type] {

    case class Props(data: visx.HierarchyPointLink[TreeNode])

    override val component = visx.LinkHorizontalStep
  }
}
