package example.facade

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object visx {

  @js.native
  @JSImport("@visx/gradient")
  object LinearGradient extends js.Object

  @js.native
  @JSImport("@visx/hierarchy")
  abstract class HierarchyPointLink[T] extends js.Object

  @js.native
  @JSImport("@visx/hierarchy")
  object Tree extends js.Object

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

  @js.native
  @JSImport("@visx/group")
  object Group extends js.Object

  @js.native
  @JSImport("@visx/hierarchy")
  def hierarchy[T](data: T): HierarchyPointNode[T] = js.native

  @js.native
  @JSImport("@visx/shape")
  object LinkHorizontal extends js.Object

  @js.native
  @JSImport("@visx/shape")
  object LinkHorizontalStep extends js.Object

}
