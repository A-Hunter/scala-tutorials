package com.scala.advanced.adv_18_self_types

object SelfTypes extends App {

  // requiring a type to be mixed

  trait Instrumentalist {
    def play(): Unit
  }

  trait Singer { self: Instrumentalist => // Self type : whoever implements Singer to implement Instrumentalist
    def sing(): Unit
  }

  class LeadSinger extends Singer with Instrumentalist {
    override def play(): Unit = ???
    override def sing(): Unit = ???
  }

//  class Vocalist extends Singer {
//    override def sing(): Unit = ???
//  }
    // => won't compile : Vocalist is not compatible with the self type

  val killerB = new Singer with Instrumentalist {
    override def play(): Unit = ???
    override def sing(): Unit = ???
  }

  class Guitarist extends Instrumentalist {
    override def play(): Unit = println("Guitar solo")
  }

  val oldMan = new Guitarist with Singer {
    override def sing(): Unit = ???
  }

  // vs inheritance
  class A
  class B extends A // B is a class of type A

  trait T
  trait S { self: T => } // S requires a T

  // Self types are used in the cake pattern : dependency injection in java

  // Dependency Injection : Like in Spring
  class Component {
    // API
  }
  class ComponentA extends Component
  class ComponentB extends Component
  class DependentComponent(val component: Component)


  // Cake Pattern :
  trait ScalaComponent {
    // API
    def action(x: Int): String
  }
  trait ScalaDependentComponent { self: ScalaComponent =>
    def dependentAction(x: Int): String = action(x) + "injected"
  }

  trait ScalaApplication { self: ScalaDependentComponent => }

  // Layer 1 - small components
  trait Picture extends ScalaComponent
  trait Stats extends ScalaComponent

  // Layer 2 - compose
  trait Profile extends ScalaDependentComponent with Picture
  trait Analytics extends ScalaDependentComponent with Stats

  // Layer 3 - app
  trait AnalyticsApp extends ScalaApplication with Analytics


  // Cyclical dependency
//  class Y extends X
//  class X extends Y
  // => won't compile because this is a cyclical dependency

  trait X { self: Y => }
  trait Y { self: X => }
  // compile, no cyclical dependency
}
