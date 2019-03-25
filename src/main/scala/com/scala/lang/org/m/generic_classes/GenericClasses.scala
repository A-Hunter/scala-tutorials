package com.scala.lang.org.m.generic_classes

/**
  * Created by Ghazi Naceur on 25/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

class Stack[A] {
  var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

class Fruit
class Apple extends Fruit
class Banana extends Fruit
class Strawberry extends Fruit

object GenericClasses extends App {
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(5)
  stack.push(6)
  stack.push(2)
  stack.push(4)
  println(stack.peek)
  println(stack.pop())
  println(stack.elements)

  val stack2 = new Stack[Fruit]
  val apple = new Apple
  val banana = new Banana
  val strawberry = new Strawberry
  stack2.push(apple)
  stack2.push(banana)
  stack2.push(strawberry)
  stack2.pop()
  stack2.pop()
  println(stack2.elements)
}
