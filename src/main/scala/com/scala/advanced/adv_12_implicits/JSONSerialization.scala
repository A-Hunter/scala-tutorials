package com.scala.advanced.adv_12_implicits

import com.scala.advanced.adv_12_implicits.JSONSerialization.JSONNumber

import java.util.Date

object JSONSerialization extends App {

  case class User(name: String, age: Int, email: String)
  case class Post(content: String, createdAt: Date)
  case class Feed(user: User, posts: List[Post])

 /*
 1- intermediate data types : Int, String, List, Date
 2- types classes for conversion to intermediate data types
 3- serialize to json
  */

  // intermediate data type
  sealed trait JSONValue {
    def stringify: String
  }

  final case class JSONString(value: String) extends JSONValue {
    override def stringify: String = "\"" + value + "\""
  }

  final case class JSONNumber(value: Int) extends JSONValue {
    override def stringify: String = "\"" + String.valueOf(value) + "\""
  }

  final case class JSONArray(values: List[JSONValue]) extends JSONValue {
    override def stringify: String = values.map(_.stringify).mkString("[",",","]")
  }

  final case class JSONObject(values: Map[String, JSONValue]) extends JSONValue {
    override def stringify: String = values.map {
      case (key, value) => "\"" + key + "\":" + value.stringify
    }.mkString("{", ",", "}")
  }

  val data = JSONObject(Map(
    "user" -> JSONString("Netero"),
    "posts" -> JSONArray(List(
        JSONString("All types of Aura"),
        JSONString("Training and other things"),
        JSONNumber(125)
      )
    )
  ))

  println(data.stringify)

  // type class
  /*
  1- type class
  2- type class instances (implicit)
  3- enrichment library to use type class instances
   */

  // 1
  trait JSONConverter[T] {
    def convert(value: T): JSONValue
  }

  // 2
  implicit object StringConverter extends JSONConverter[String] {
    override def convert(value: String): JSONValue = JSONString(value)
  }

  implicit object NumberConverter extends JSONConverter[Int] {
    override def convert(value: Int): JSONValue = JSONNumber(value)
  }

  implicit object ArrayConverter extends JSONConverter[List[JSONValue]] {
    override def convert(value: List[JSONValue]): JSONValue = JSONArray(value)
  }

  implicit object UserConverter extends JSONConverter[User] {
    override def convert(user: User): JSONValue = JSONObject(Map(
      "name" -> JSONString(user.name),
      "age" -> JSONNumber(user.age),
      "email" -> JSONString(user.email)
    ))
  }

  implicit object PostConverter extends JSONConverter[Post] {
    override def convert(post: Post): JSONValue = JSONObject(Map(
      "content" -> JSONString(post.content),
      "createdAt" -> JSONString(post.createdAt.toString)
    ))
  }

  implicit object FeedConverter extends JSONConverter[Feed] {
    override def convert(feed: Feed): JSONValue = JSONObject(Map(
//      "user" -> UserConverter.convert(feed.user), // TODO
//      "posts" -> ArrayConverter.convert(feed.posts.map(PostConverter.convert)) // TODO
//    "posts" -> JSONArray(feed.posts.map(PostConverter.convert))
      // converted to the following, using JSONOps :
    "user" -> feed.user.toJSON,
    "posts" -> ArrayConverter.convert(feed.posts.map(_.toJSON))
    ))
  }

  // 3
  implicit class JSONOps[T](value: T) {
    def toJSON(implicit converter: JSONConverter[T]): JSONValue =
      converter.convert(value)
  }

  // call stringify on result
  val now = new Date(System.currentTimeMillis())
  val netero = User("Netero", 125, "issac.netero@hunter.com")
  val feed = Feed(netero, List(
    Post("All types of Aura", now),
    Post("Training and other things", now)))

  println(feed.toJSON.stringify)
}
