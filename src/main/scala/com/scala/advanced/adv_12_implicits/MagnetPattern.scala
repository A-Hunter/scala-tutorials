package com.scala.advanced.adv_12_implicits

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MagnetPattern extends App {

  // method overloading
  class P2PRequest

  class P2PResponse

  class Serializer[T]

  trait Actor {
    def receive(statusCode: Int): Int

    def receive(request: P2PRequest)

    def receive(response: P2PResponse)

    //    def receive[T](message: T)(implicit serializer: Serializer[T]): Int
    //    To be replaced with a type bound : more readable :
    def receive[T: Serializer](message: T): Int

    def receive[T: Serializer](message: T, statusCode: Int): Int

    def receive(future: Future[P2PRequest]): Int
    // lots of overloads
  }

  /*
  Problems :
    1- type erasure :
        def receive(future: Future[P2PRequest]): Int
        def receive(future: Future[P2PResponse]): Int
          => This code won't compile
    2- lifting doesn't work for all overloads :
        val receiveFV = receive _ // won't work because the compiler can't determine what the "_" stands for. It could
                  a value of type P2PRequest or P2PResponse ... etc
    3- code duplication
    4- type inference and default args
        actor.receive(?!) // the compiler can't guess what's the default value to use
   */

  trait MessageMagnet[Result] {
    def apply(): Result
  }

  def receive[R](magnet: MessageMagnet[R]): R = magnet()

  implicit class FromP2PRequest(request: P2PRequest) extends MessageMagnet[Int] {
    override def apply(): Int = {
      // logic for handling P2PRequest
      println("Handling P2PRequest : " + request)
      12
    }
  }

  implicit class FromP2PResponse(response: P2PResponse) extends MessageMagnet[Int] {
    override def apply(): Int = {
      // logic for handling P2PResponse
      println("Handling P2PRequest : " + response)
      21
    }
  }

  // The compiler will look for the implicit conversions
  receive(new P2PRequest)
  receive(new P2PResponse)

  //  Benefits of the Magnet Pattern :
  //  1- No more type erasure problem
  implicit class FromRequestFuture(future: Future[P2PRequest]) extends MessageMagnet[Int] {
    override def apply(): Int = 2
  }

  implicit class FromResponseFuture(future: Future[P2PResponse]) extends MessageMagnet[Int] {
    override def apply(): Int = 4
  }

  println(receive(Future(new P2PRequest)))
  println(receive(Future(new P2PResponse)))

  // 2- lifting works :
  trait MathLib {
    def add1(x: Int): Int = x + 1
    def add1(s: String): Int = s.toInt + 1
    // add1 overloads
  }

  // magnetize
  trait AddMagnet {
    def apply(): Int
  }
// We didn't add a type parameter in this trait (AddMagnet[T]). This won't work because the compile won't be enable to guess
// for which type the lifted function (add1()) will apply to
  def add1(magnet: AddMagnet): Int = magnet()

  implicit class AddInt(x: Int) extends AddMagnet {
    override def apply(): Int = x + 1
  }

  implicit class AddString(str: String) extends AddMagnet {
    override def apply(): Int = str.toInt + 1
  }

  val addFV = add1 _
  println(addFV("1"))
  println(addFV(1))

  /*
  Drawbacks of Magnet Pattern:
  1- super verbose
  2- harder to read
  3- you can't name or place default arguments
  4- call by name does not work correctly
   */

  // Proof that call by name does not work correctly
  class Handler {
    def handle(s: => String): Unit = {
      println(s)
      println(s)
    }
    // other overloads

    trait HandleMagnet {
      def apply(): Unit
    }

    def handle(magnet: HandleMagnet) = magnet()

    implicit class StringHandle(s: => String) extends HandleMagnet {
      override def apply(): Unit = {
        println(s)
        println(s)
      }
    }

    def sideEffectMethod(): String = {
      println("something")
      "else where"
    }

//    handle(sideEffectMethod())
    handle {
      println("something")
      "else where" // only this string is converted to magnet class
//    The same as writing : new StringHandle("else where")
    }
  }
}
