def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {

  @annotation.tailrec
  def go(curr: Int, next: Int, flag: Boolean): Boolean = {
    // Return once at end of list
    if(as.length == next) flag
    else {
      // println(s"Curr:${as(curr)} <= Next:${as(next)} = ${gt(as(curr), as(next))}")
      if(!gt(as(curr), as(next))) 
        false // not sorted, failed
      else 
        go(next, next+1, flag) // sorted so far...
    }
  }

  if(as.isEmpty || as.length == 1) true 
  else go(0, 1, true)
}


// val empty = Array[Int]()
// println(isSorted(empty, (x:Int,y:Int) => x <= y))

// val single = Array[Int](1)
// println(isSorted(single, (x:Int,y:Int) => x <= y))


// val notSorted = Array[Int](1,2,5,8,3,4,5,1)
// println(isSorted(notSorted, (x:Int,y:Int) => x <= y))

// val sorted = notSorted.sortWith(_ < _)
// println(isSorted(sorted, (x:Int,y:Int) => x <= y))


// val empty = Array[Double]()
// println(isSorted(empty, (x:Double,y:Double) => x <= y))

// val single = Array[Double](1.3)
// println(isSorted(single, (x:Double,y:Double) => x <= y))


// val notSorted = Array[Double](1.0,2.0,5.0,8.0,3.9,4.9,5,1.3)
// println(isSorted(notSorted, (x:Double,y:Double) => x <= y))

// val sorted = notSorted.sortWith(_ < _)
// println(isSorted(sorted, (x:Double,y:Double) => x <= y))



case class Player(name: String, score: Double) {
  override def toString(): String = name
}

val empty = Array[Player]()
println(isSorted(empty, (x:Player,y:Player) => x.score <= y.score))

val single = Array[Player](Player("Tom", 7.9))
println(isSorted(single, (x:Player,y:Player) => x.score <= y.score))


val notSorted = Array[Player](Player("Sue", 7.1),Player("Charles", 3.3),Player("Will", 3.4))
println(isSorted(notSorted, (x:Player,y:Player) => x.score <= y.score))

val sorted = notSorted.sortWith(_.score < _.score)
println(isSorted(sorted, (x:Player,y:Player) => x.score <= y.score))

