package com.scala.advanced.adv_8_intro_to_concurrency

object ThreadExamples extends App {

  // Exercise 1 :
//  def createInceptionThreads(maxThreads: Int, i: Int = 1): Thread = new Thread(() => {
//    if (i < maxThreads) {
//      val newThread = createInceptionThreads(maxThreads, i + 1)
//      newThread.start()
//      newThread.join()
//    }
//    println("Hello from thread " + i)
//  })
//  createInceptionThreads(50).start()

  // Exercise 2 :
  var x = 0
  val threads = (1 to 100).map(_ => new Thread(() => println(x += 1)))
  threads.foreach(_.start)
  threads.foreach(_.join) // blocks the thread, to make the execution sequential
  println(x)

  // Exercise 2 : 3 sleep fallacy
  var message = ""
  val aThread = new Thread(() => {
    Thread.sleep(1000)
    message = "This is Scala"
  })
  message = "Scala again"

  aThread.start()
  Thread.sleep(2000)
  aThread.join()
  println(message)
  /*
  The value of "message" is almost always "This is Scala", but it is not guaranteed, because :
    (main thread)
      message = "This is Scala"
      aThread.start()
      sleep() // relieves the execution
    (aThread)
      sleep() // relieves the execution
    (OS gives the CPU to some important thread - takes CPU for more than 2 seconds)
    (OS gives the CPU to the main thread not to aThread)
      println("Scala again")
    (OS gives the CPU to aThread) // At this point, it's too late because the println statement has already finished executing
      message = "This is Scala"

    // Solution :
    synchronized() cannot be a fix for this issue, because it is only useful for concurrent modification.
    join() is a solution for this issue, because we're dealing with a sequence execution, so before printing the message
    we can join thread
   */
}
