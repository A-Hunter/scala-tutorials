package com.scala.lang.org.t.self_type

/**
  * Created by Ghazi Naceur on 27/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

trait User {
  def username: String
}

trait Tweeter {
  this: User => // reassign this
  def tweet(tweetText: String) = println(s"$username: $tweetText")
}

class VerifiedTweeter(val username_ : String) extends Tweeter with User { // We mixin User because Tweeter required it
  def username = s"real $username_"
}

// Because we said this: User => in trait Tweeter, now the variable username is in scope for the
// tweet method. This also means that since VerifiedTweeter extends Tweeter, it must also mix-in User
// (using with User).

object SelfType extends App {
  val realPers = new VerifiedTweeter("Pers")
  realPers.tweet("Just spilled my glass of lemonade")
  // prints "real Pers: Just spilled my glass of lemonade"
}
