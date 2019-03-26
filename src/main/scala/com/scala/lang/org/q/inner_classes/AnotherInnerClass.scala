package com.scala.lang.org.q.inner_classes

/**
  * Created by Ghazi Naceur on 26/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

class AnotherGraph {
  class AnotherNode {
    var connectedNodes: List[AnotherGraph#AnotherNode] = Nil
    def connectTo(node: AnotherGraph#AnotherNode) {
      if (!connectedNodes.exists(node.equals)) {
        connectedNodes = node :: connectedNodes
      }
    }
  }
  var nodes: List[AnotherNode] = Nil
  def newNode: AnotherNode = {
    val res = new AnotherNode
    nodes = res :: nodes
    res
  }
}

object AnotherInnerClass extends App {
  val graph1: AnotherGraph = new AnotherGraph
  val node1: graph1.AnotherNode = graph1.newNode
  val node2: graph1.AnotherNode = graph1.newNode
  node1.connectTo(node2)      // legal
  val graph2: AnotherGraph = new AnotherGraph
  val node3: graph2.AnotherNode = graph2.newNode
  node1.connectTo(node3)      // legal as well because we changed the type of variable nodes to
                              // AnotherGraph#AnotherNode.
}
