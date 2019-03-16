/**
  * Created by Ghazi Naceur on 16/03/2019
  * Email: ghazi.ennacer@gmail.com
  */


val pegs = Array((1 to 5).toList, List[Int](), List[Int]())

def moveOneDisk(from: Int, to: Int): Unit = {
  require(pegs(to).isEmpty || pegs(from).head < pegs(to).head)
  pegs(to) ::= pegs(from).head
  pegs(from) = pegs(from).tail
}

def moveStack(n: Int, from: Int, to: Int): Unit = {
  if (n == 1) {
    moveOneDisk(from, to)
  } else {
    val other = 3 - from - to
    moveStack(n - 1, from, other)
    moveOneDisk(from, to)
    moveStack(n - 1, other, to)
  }
}

println(pegs.mkString(", "))
moveStack(pegs(0).length, 0, 2)
println(pegs.mkString(", "))