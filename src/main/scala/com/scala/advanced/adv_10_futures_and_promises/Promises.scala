package com.scala.advanced.adv_10_futures_and_promises

import scala.concurrent.Promise
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
object Promises extends App {

  val promise = Promise[Int]() // A sort of a controller over a Future
  val future = promise.future

  // thread 1 : consumer
  future.onComplete {
    case Success(value) => println("[consumer] I've received : "+ value)
  }

  // thread 2 : producer
  val producer =  new Thread(() => {
    println("[producer] crunching numbers...")
    Thread.sleep(500)
    // fulfilling the promise
    promise.success(42) // This will trigger the "line 12: future.onComplete {"
    println("[producer] done")
  })
  producer.start()
  Thread.sleep(1000)
}
