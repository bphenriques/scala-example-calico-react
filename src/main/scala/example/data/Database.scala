package example.data

import cats.effect.IO
import cats.syntax.all.*
import fs2.io.file.{Files, Path}
import io.circe.{parser, Codec, Decoder}
import example.data.JsonCodec.*
import example.data.model.{Data, Node, Profile}

trait Database {
  def user(): Profile

  def nodes(): List[Node]
}

object Database {

  given Codec[Data] =
    JsonCodec.dataCodec // question: Scala 3 requires being explicit like this rather than just importing?

  def make(file: Path): IO[Database] =
    readFromFile[Data](file).map { data =>
      new Database {
        override def user(): Profile = data.profile

        override def nodes(): List[Node] = data.nodes
      }
    }

  private def readFromFile[A: Decoder](path: Path): IO[A] =
    Files[IO]
      .readUtf8(path)
      .compile
      .string
      .map(parser.parse(_).flatMap(json => json.as[A]))
      .flatMap(IO.fromEither)
      .adaptError(t => new RuntimeException(s"Failed to read the database in $path: ${}"))
}
