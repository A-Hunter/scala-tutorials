package com.scala.lang.org.q.inner_classes

/**
  * Created by Ghazi Naceur on 26/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

class Graph {

  class Node {
    var connectedNodes: List[Node] = Nil

    def connectTo(node: Node) {
      if (!connectedNodes.exists(node.equals)) {
        connectedNodes = node :: connectedNodes
      }
    }
  }

  var nodes: List[Node] = Nil

  def newNode: Node = {
    val res = new Node
    nodes = res :: nodes
    res
  }
}

object InnerClass extends App {
  //  The class Node is a path-dependent type because it is nested in the class Graph.
  //  Therefore, all nodes in the connectedNodes must be created using the newNode from the
  //  same instance of Graph.
  val graph1: AnotherGraph = new AnotherGraph
  val node1: graph1.AnotherNode = graph1.newNode
  val node2: graph1.AnotherNode = graph1.newNode
  val node3: graph1.AnotherNode = graph1.newNode
  node1.connectTo(node2)
  node3.connectTo(node1)

  //  If we now have two graphs, the type system of Scala does not allow us to mix nodes defined
  //  within one graph with the nodes of another graph, since the nodes of the other graph have a
  //  different type. Here is an illegal program:
//  val graph2: Graph = new Graph
//  val node3: graph2.Node = graph2.newNode
//  node1.connectTo(node3)
}
