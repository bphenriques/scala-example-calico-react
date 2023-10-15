package example.data

import cats.syntax.all.*
import example.data.model.{Data, Node, Profile}
import io.circe.syntax.*
import io.circe.{Codec, Decoder, Encoder, Json}

object JsonCodec {

  given dataCodec: Codec[Data] = {
    val profileLabel = "profile"
    val nodesLabel   = "nodes"

    val d: Decoder[Data] = (
      Decoder[Profile].at(profileLabel),
      Decoder[List[Node]].at(nodesLabel),
    ).mapN(Data.apply)

    val e: Encoder[Data] = database =>
      Json.obj(
        profileLabel -> database.profile.asJson,
        nodesLabel   -> database.nodes.asJson,
      )

    Codec.from(d, e)
  }

  given nodeCodec: Codec[Node] = {
    val idLabel     = "name"
    val childsLabel = "childs"
    val notesLabel  = "notes"

    val d: Decoder[Node] = (
      Decoder[String].at(idLabel),
      Decoder[List[String]].at(childsLabel),
      Decoder[String].at(notesLabel),
    ).mapN(Node.apply)

    val e: Encoder[Node] = node =>
      Json.obj(
        idLabel     -> node.id.asJson,
        childsLabel -> node.childs.asJson,
        notesLabel  -> node.notes.asJson,
      )

    Codec.from(d, e)
  }

  given profileCodec: Codec[Profile] = {
    val nameLabel  = "name"
    val notesLabel = "notes"

    val d: Decoder[Profile] = (
      Decoder[String].at(nameLabel),
      Decoder[String].at(notesLabel),
    ).mapN(Profile.apply)

    val e: Encoder[Profile] = user =>
      Json.obj(
        nameLabel  -> user.name.asJson,
        notesLabel -> user.notes.asJson,
      )

    Codec.from(d, e)
  }
}
