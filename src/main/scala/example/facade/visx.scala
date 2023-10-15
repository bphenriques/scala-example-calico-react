package example.facade

import slinky.core.facade.ReactElement
import slinky.core.{ExternalComponent, ExternalComponentWithAttributes}
import slinky.web.svg.a

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object visx {

  object LinearGradient extends ExternalComponent {
    case class Props(id: String, from: String, to: String)

    @js.native
    @JSImport("@visx/gradient")
    object LinearGradient extends js.Object

    override val component = LinearGradient
  }

  @js.native
  @JSImport("@visx/hierarchy")
  abstract class HierarchyPointLink[T] extends js.Object

  @js.native
  trait TreeNode extends js.Object {
    val name: String                 = js.native
    val children: js.Array[TreeNode] = js.native
  }

  object TreeNode {

    def apply(name: String, children: Array[TreeNode]): TreeNode =
      js.Dynamic.literal(name = name, children = js.Array(children: _*)).asInstanceOf[TreeNode]
  }

  object Tree extends ExternalComponent {

    @js.native
    @JSImport("@visx/hierarchy")
    object Tree extends js.Object

    case class Props(
      root: HierarchyPointNode[TreeNode],
      size: Array[Int],
      children: HierarchyPointNode[TreeNode] => ReactElement,
    )

    override val component = Tree
  }

  // https://github.com/tomwanzek/d3-v4-definitelytyped/blob/master/src/d3-hierarchy/index.d.ts#L74
  @js.native
  @JSImport("@visx/hierarchy/lib/types")
  class HierarchyPointNode[T] extends js.Object {
    val x: Int = js.native
    val y: Int = js.native

    def links(): js.Array[HierarchyPointLink[T]] = js.native

    def descendants(): js.Array[HierarchyPointNode[T]] = js.native

    val data: T = js.native
  }

  object Group extends ExternalComponent {

    @js.native
    @JSImport("@visx/group")
    object Group extends js.Object
    case class Props(top: Int, left: Int)

    override val component = Group
  }

  object Hierarchy {

    @js.native
    @JSImport("@visx/hierarchy")
    def hierarchy(data: TreeNode): HierarchyPointNode[TreeNode] = js.native
  }

  object LinkHorizontal extends ExternalComponentWithAttributes[a.tag.type] {

    @js.native
    @JSImport("@visx/shape")
    object LinkHorizontal extends js.Object

    case class Props(data: HierarchyPointLink[TreeNode])

    override val component = LinkHorizontal
  }

  object LinkHorizontalStep extends ExternalComponentWithAttributes[a.tag.type] {

    @js.native
    @JSImport("@visx/shape")
    object LinkHorizontalStep extends js.Object

    case class Props(data: HierarchyPointLink[TreeNode])

    override val component = LinkHorizontalStep
  }
}
