package com.scala.tutorials.b.classes

/**
  * Created by Ghazi Naceur on 25/10/2018.
  */
object Run {
  implicit class IntTimes(x: Int) {
    def times [A](f: =>A): Unit = {
      def loop(current: Int): Unit =

        if(current > 0){
          f
          loop(current - 1)
        }
      loop(x)
    }
  }
}
