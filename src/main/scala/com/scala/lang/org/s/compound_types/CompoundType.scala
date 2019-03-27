package com.scala.lang.org.s.compound_types

/**
  * Created by Ghazi Naceur on 27/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}
trait Resetable {
  def reset: Unit
}

object CompoundType extends App {
  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset
    cloned
  }
}
