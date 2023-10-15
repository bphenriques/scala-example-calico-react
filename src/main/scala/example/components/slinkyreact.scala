package example.components

import calico.*
import calico.html.io.{*, given}
import cats.effect.*
import cats.syntax.all.*
import fs2.dom.*
import org.scalajs.dom
import org.scalajs.dom.Element
import slinky.core.facade.ReactElement
import slinky.web.ReactDOMClient

object slinkyreact {

  def reactDiv(id: String, component: IO[ReactElement]): Resource[IO, HtmlElement[IO]] =
    div(idAttr := id).flatMap { container =>
      Resource
        .make(
          (
            IO(ReactDOMClient.createRoot(container.asInstanceOf[Element])),
            component,
          ).flatMapN { case (root, reactComponent) =>
            IO(root.render(reactComponent)).as(root)
          },
        )(root => IO(root.unmount()))
        .map(_ => container)
    }
}
