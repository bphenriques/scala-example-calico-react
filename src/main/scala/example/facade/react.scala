package example.facade

import org.scalajs.dom.Element
import slinky.core.facade.ReactElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object react {

  // For now, needs to be a Slinky element
  // @js.native
  // trait ReactElement extends js.Object

  @js.native
  trait ReactInstance extends js.Object

  trait ReactRoot extends js.Object {
    def render(component: ReactElement): ReactInstance

    def unmount(): Unit
  }

  @js.native
  @JSImport("react-dom/client", JSImport.Namespace, "ReactDOM")
  object ReactDOMClient extends js.Object {
    def createRoot(target: Element): ReactRoot = js.native

    def hydrate(component: ReactElement, target: Element): ReactRoot = js.native
  }
}
