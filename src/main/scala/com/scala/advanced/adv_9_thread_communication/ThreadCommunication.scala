package com.scala.advanced.adv_9_thread_communication

import scala.collection.mutable
import scala.util.Random

/**
  * Created by Daniel.
  */
object ThreadCommunication extends App {

  /*
    the producer-consumer problem

    producer -> [ ? ] -> consumer
   */
  class SimpleContainer {
    private var value: Int = 0

    def isEmpty: Boolean = value == 0

    def set(newValue: Int) = value = newValue

    def get = {
      val result = value
      value = 0
      result
    }
  }

  def naiveProdCons(): Unit = {
    val container = new SimpleContainer

    val consumer = new Thread(() => {
      println("[consumer] waiting...")
      while (container.isEmpty) {
        println("[consumer] actively waiting...")
      }

      println("[consumer] I have consumed " + container.get)
    })

    val producer = new Thread(() => {
      println("[producer] computing...")
      Thread.sleep(500)
      val value = 42
      println("[producer] I have produced, after long work, the value " + value)
      container.set(value)
    })

    consumer.start()
    producer.start()
  }

  naiveProdCons()

  /*
  someObject.synchronized {...} // will lock the object's monitor.
  A monitor is a data structure internally used in the JVM to keep track of which object is locked by which thread.
  Once you have locked an object, any other thread that tries to evaluate that same expression will block until you're done evaluating.
  When you're done, you release the lock and the other thread will be free to evaluate the same expression, if it reaches that point.

  Only AnyRefs can have synchronized blocks (primitive types do not synchronized blocks)
  Keep thread safety at all times in parallel apps.

  We can use "wait and notify" for parallel processing :
  - wait() on an object's monitor suspends the calling thread indefinitely => release the lock and wait
  After waiting, the thread will lock the monitor again and continue the processing
  - notify() : signal 1 sleeping thread that may continue, after it acquires the lock on the monitor again.
  After processing, it will unlock the monitor
  If you want to signal/awaken all available threads, you can use "notifyAll()".
  */

  def smartProdCons(): Unit = {
    val container = new SimpleContainer

    val consumer = new Thread(() => {
      println("[consumer] waiting...")
      container.synchronized {
        container.wait()
      }
      // container must have some value
      println("[consumer] I have consumed "+ container.get)
    })

    val producer = new Thread(() => {
      println("[producer] processing...")
      Thread.sleep(2000)
      val value = 42
      container.synchronized {
        println("[producer] producing value : "+ value)
        container.set(value)
        container.notify()
      }
    })

    consumer.start()
    producer.start()
  }

  smartProdCons()


}