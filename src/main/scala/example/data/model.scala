package example.data

object model {
  case class Data(profile: Profile, nodes: List[Node])

  case class Profile(name: String, notes: String)
  case class Node(id: String, childs: List[String], notes: String)
}
