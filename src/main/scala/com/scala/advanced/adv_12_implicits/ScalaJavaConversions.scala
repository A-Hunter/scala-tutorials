package com.scala.advanced.adv_12_implicits

import java.{util => ju}
import scala.collection.mutable

object ScalaJavaConversions extends App {

  import collection.JavaConverters._

  val javaSet: ju.Set[Int] = new ju.HashSet[Int]()
  (1 to 5).foreach(javaSet.add)
  println(javaSet)

  val scalaSet = javaSet.asScala

  import collection.mutable._
  val suNumbersBuffer = ArrayBuffer[Int](1,2,3)
  val juNumbersBuffer = suNumbersBuffer.asJava

  println(juNumbersBuffer.asScala eq suNumbersBuffer) // // the same reference

  val suNumbers: List[Int] = List(1,2,3)
  val juNumbers = suNumbers.asJava
  val backToScala: mutable.Buffer[Int] = juNumbers.asScala

  println(suNumbers eq backToScala) // not the same reference
  println(suNumbers == backToScala)

//  juNumbers.add(7) // UnsupportedOperation because it suppose to be an immutable list

  class ToScala[T](value: => T) {
    def asScala: T = value
  }

  implicit def asScalaOptional[T](o: ju.Optional[T]): ToScala[Option[T]] = new ToScala[Option[T]](
    if (o.isPresent) Some(o.get)
    else None
  )

  val juOptional: ju.Optional[Int] = ju.Optional.of(2)
  val scalaOption = juOptional.asScala
  println(scalaOption)
}
