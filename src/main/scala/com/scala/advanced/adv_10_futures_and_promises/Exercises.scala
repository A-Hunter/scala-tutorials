package com.scala.advanced.adv_10_futures_and_promises

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success, Try}

object Exercises extends App {

  /*
  1- Fulfill a future immediately with a value
  2- inSequence(fa, fb) : after fa is finished, launch fb
  3- first(fa, fb) => new future with the first value of the 2 futures
  4- last(fa, fb) => new future with the last value of the 2 futures
  5- retryUntil(action: () => Future[T], condition: T => Boolean): Future[T] // Repeat computing until reaching the condition
   */

  // 1- Fulfill a future immediately with a value
  def fulfillImmediately[T](value: T): Future[T] = Future(value)

  // 2- inSequence(fa, fb) : after fa is finished, launch fb
  def inSequence[A, B](first: Future[A], second: Future[B]): Future[B] =
    first.flatMap(_ => second) // use flatMap to get the result of "first", so first has already finished executing

  // 3- first(fa, fb) => new future with the first value of the 2 futures
  def first[A, B](fa: Future[A], fb: Future[A]): Future[A] = {
    val promise = Promise[A]
    fa.onComplete(promise.tryComplete)
    fb.onComplete(promise.tryComplete)
    promise.future
  }

  // 4- last(fa, fb) => new future with the last value of the 2 futures
  def last[A, B](fa: Future[A], fb: Future[A]): Future[A] = {
    // first promise which both futures will try to complete
    // second promise which will be completed by the last future (the one that failed to complete the first promise)
    val bothPromise = Promise[A]
    val lastPromise = Promise[A]
    val checkAndComplete = (result: Try[A]) =>
      if (!bothPromise.tryComplete(result))
        lastPromise.complete(result)

    fa.onComplete(checkAndComplete)
    fb.onComplete(checkAndComplete)
    lastPromise.future
  }

  val fast = Future {
    Thread.sleep(100)
    42
  }

  val slow =  Future {
    Thread.sleep(200)
    50
  }

  first(fast, slow).foreach(println)
  last(fast, slow).foreach(println)

  Thread.sleep(1000)

  // 5- retryUntil(action: () => Future[T], condition: T => Boolean): Future[T] // Repeat computing until reaching the condition
  def retryUntil[A](action: () => Future[A], condition: A => Boolean): Future[A] =
    action()
      .filter(condition)
      .recoverWith {
        case _ => retryUntil(action, condition)
      }

  val random = new Random()
  val action = () => Future {
    Thread.sleep(100)
    val nextValue = random.nextInt(100)
    println("Generated value : "+ nextValue)
    nextValue
  }

  retryUntil(action, (x: Int) => x < 10).foreach(result => println("settled at : "+ result))
  Thread.sleep(10000)
}
