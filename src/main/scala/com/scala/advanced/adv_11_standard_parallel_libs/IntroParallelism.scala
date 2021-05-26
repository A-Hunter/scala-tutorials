package com.scala.advanced.adv_11_standard_parallel_libs

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.atomic.AtomicReference
import scala.collection.parallel.ForkJoinTaskSupport
import scala.collection.parallel.immutable.ParVector

object IntroParallelism extends App {

  val parallelList = List(1,2,3).par // .par : transforms List to a Parallel List, which means that multiple threads will be
                                      // used to handle elements from the list at the same time
  val parallelVector = ParVector[Int](1,2,3)

  def measure[T](operation: => T): Long = {
    val time = System.currentTimeMillis()
    operation
    System.currentTimeMillis() - time
  }

  val list = (1 to 10000000).toList
  val serialTime = measure {
    list.map(_ + 1)
  }
  println("serial time = "+ serialTime)

  val parallelTime = measure {
    list.par.map(_ + 1)
  }
  println("parallel time = "+ parallelTime)

  /*
  For a small sequence of elements (few thousands), it is recommended to use an ordinary List.
  If we're dealing with a big List (millions of elements), it will be cheaper to use a parallel list.
  Parallel list operates on the Map-Reduce model :
  1- split elements into chunks, which will be processed independently by each thread - Scala : Splitter
  2- apply operation
  3- recombine result of each thread : Reduce - Scala : Combiner

  thread operations on parallel lists : map, flatMap, filter, foreach
  non thread operations on parallel lists : reduce, fold
   */

  println(List(1,2,3).reduce(_-_))
  println(List(1,2,3).par.reduce(_-_)) // Not safe, because elements could be processed in another order

  // second problem with parallel lists : sometimes the need for synchronization
  var sum = 0
  List(1,2,3).par.foreach(sum += _)
  println(sum) // Risk of race-condition. Here the result 6 is not guaranteed, because there are concurrent threads working,
  // and one of them could overwrite the final result

  // Configuring Parallel Collections
  parallelVector.tasksupport = new ForkJoinTaskSupport(new ForkJoinPool(2)) // 2 is the number of thread to
  // manage the values inside the parallel vector
  /*
  Alternatives for ForkJoinPool :
    - ThreadPoolTaskSupport - deprecated
    - ExecutionContextTaskSupport(EC)
    - Creating a custom task support with : new TaskSupport { ... } and override few methods
   */

  // Atomic operations and references
  val atomic = new AtomicReference[Int](2)
  val currentValue = atomic.get() // .get is thread-safe. In this moment, no other thread can read from "atomic"
  atomic.set(4) // .set is thread-safe. In this moment, no other thread can write to "atomic"
  atomic.getAndSet(6) // thread-safe get and set
  atomic.compareAndSet(10, 20) // if value == 10, then set value == 20 // thread-safe
  // .compareAndSet => .compare does a shallow equality, not a deep one == reference equality
  atomic.updateAndGet(_ + 1) // thread-safe function run
  atomic.getAndUpdate(_ + 1) // thread-safe
  atomic.accumulateAndGet(12, _ + _) // thread-safe
  atomic.getAndAccumulate(12, _ + _) // thread-safe
}
