package com.scala.advanced.adv_9_thread_communication

object ThreadCommMoreExamples extends App {

  // notifyAll example
  def testNotifyAll(): Unit = {
    val bell = new Object
    (1 to 10).foreach(i => new Thread(() => {
      bell.synchronized {
        println(s"[thread $i] is waiting")
        bell.wait()
        println(s"[thread $i] woke up")
      }
    }).start())

    new Thread(() => {
      Thread.sleep(2000)
      println("[announcer] this is an announce")
      bell.synchronized {
        bell.synchronized {
          bell.notifyAll()
//          bell.notify()
        }
      }
    }).start()
  }

//  testNotifyAll()


  // Deadlock example :
  case class  Friend(name: String) {
    def bow(other: Friend): Unit = {
      this.synchronized {
        println(s"$this: I am bowing to my friend $other")
        other.rise(this)
        println(s"$this: my friend $other has risen")
      }
    }

    def rise(other: Friend): Unit = {
      this.synchronized {
        println(s"$this: I am rising to my friend $other")
      }
    }

    var side = "right"
    def switchSide(): Unit = {
      if (side == "right") side = "left"
      else side = "right"
    }

    def pass(other: Friend): Unit = {
      while (this.side == other.side) {
        println(s"$this: you can pass first ...")
        switchSide()
        Thread.sleep(1000)
      }
    }
  }

  val shisui = Friend("Shisui")
  val itachi = Friend("Itachi")

  new Thread(() => shisui.bow(itachi)).start() // Shisui's lock, then Itachi's lock
  new Thread(() => itachi.bow(shisui)).start() // Itachi's lock, then Shisui's lock
  // Both of them is blocked and can't print the following statement : println(s"$this: I am rising to my friend $other")

  // Liveblock example
  new Thread(() => shisui.pass(itachi)).start()
  new Thread(() => itachi.pass(shisui)).start()

}
