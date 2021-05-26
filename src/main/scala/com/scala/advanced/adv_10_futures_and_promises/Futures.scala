package com.scala.advanced.adv_10_futures_and_promises

import com.scala.advanced.adv_10_futures_and_promises.Futures.SocialNetwork.{fetchBestFriends, names}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object Futures extends App {

  def calculate: Int = {
    Thread.sleep(2000)
    42
  }

  val aFuture = Future {
    calculate
  }

  println(aFuture.value)
  println("Waiting for the future")
  aFuture.onComplete { // partial function
    case Failure(exception) => println("This is the exception : "+ exception)
    case Success(value) => println("value : "+ value)
  }

  Thread.sleep(3000)

  // Mini-social network
  case class Profile(id: String, name: String) {
    def poke(anotherProfile: Profile): Unit =
      println(s"${this.name} is poking ${anotherProfile.name}")
  }

  object SocialNetwork {
    // database
    val names = Map(
      "id.1" -> "Netero",
      "id.2" -> "Itachi",
      "id.3" -> "Shisui",
      "id.4" -> "Hisoka",
      "id.5" -> "Takamora",
      "id.dummy" -> "dummy"
    )

    val friends = Map(
      "id.1" -> "id.4",
      "id.2" -> "id.3",
      "id.5" -> "id.2"
    )

    val random = new Random()

    // API
    def fetchProfile(id: String): Future[Profile] = Future {
      Thread.sleep(random.nextInt(300))
      Profile(id, names(id))
    }

    def fetchBestFriends(profile: Profile): Future[Profile] = Future {
      Thread.sleep(random.nextInt(400))
      val bfIf = friends(profile.id)
      Profile(bfIf, names(bfIf))
    }
  }

  val netero = SocialNetwork.fetchProfile("id.1")
  netero.onComplete {
    case Failure(exception) => throw new NoSuchElementException("Error : "+exception)
    case Success(neteroProfile) =>
      fetchBestFriends(neteroProfile).onComplete {
        case Failure(exception) => throw new NoSuchElementException("Error : "+exception)
        case Success(bfProfile) => neteroProfile.poke(bfProfile)
      }
  }
  Thread.sleep(1000)

  // Functional compositions of Future
  // map, flatMap, filter
  val distinguishedName = netero.map(prf => prf.name)
  val neteroBf = netero.flatMap(profile => SocialNetwork.fetchBestFriends(profile))
  val hisokaBfRestricted = neteroBf.filter(profile => profile.name.startsWith("id"))

  // for-comprehension
  for {
    netero <- SocialNetwork.fetchProfile("id.1")
    neteroBf <- SocialNetwork.fetchBestFriends(netero)
  } yield netero.poke(neteroBf)

  Thread.sleep(1000)

  // fallbacks :
  // 1- recover :
  val dummy = SocialNetwork.fetchProfile("unknown id").recover {
    case e: Throwable => Profile("id.dummy", "dummy")
  }

  // 2- recoverWith :
  val fetchefDummy = SocialNetwork.fetchProfile("unknown id").recoverWith {
    case e: Throwable => SocialNetwork.fetchProfile("id.dummy")
  }

  // 3- fallbackTo :
  val fallbackRes = SocialNetwork.fetchProfile("unknown id").fallbackTo(SocialNetwork.fetchProfile("id.dummy"))
}
