package example

import scalajs.js

object model {

  @js.native
  trait TreeNode extends js.Object {
    val name: String                 = js.native
    val children: js.Array[TreeNode] = js.native
  }

  object TreeNode {

    def apply(name: String, children: Array[TreeNode]): TreeNode =
      js.Dynamic.literal(name = name, children = js.Array(children: _*)).asInstanceOf[TreeNode]
  }

  val Default: TreeNode = TreeNode(
    "A",
    Array(
      TreeNode("A1", Array()),
      TreeNode("A2", Array()),
    ),
  )
}
