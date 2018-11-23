package com.scala.tutorials.b.classes

/**
  * Created by Ghazi Naceur on 23/11/2018.
  */
class User (val name: String) {

  def greet:String = s"Hello ! It is $name talking to you"

  override def toString: String = s"User $name"
}

object Test {
  def main(args: Array[String]): Unit = {

    val user = new User("admin")
    println(user.greet)

    val list = List(new User("mlkjh"), new User("abcde"), new User("ftryp"))
    println(list.map(_.name.length))
    println(list.sortBy(_.name))
    println(list.find(_.name contains "bcd"))
  }

}
