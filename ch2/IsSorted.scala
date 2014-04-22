def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {

  @annotation.tailrec
  def go(curr: Int, next: Int, flag: Boolean): Boolean = {
    if(as.length == next) flag
    else {
      println(s"Curr:${as(curr)} <= Next:${as(next)} = ${gt(as(curr), as(next))}")
      if(!gt(as(curr), as(next))) false
      else go(next, next+1, flag)
    }
  }

  if(as.isEmpty || as.length == 1) true 
  else go(0, 1, true)
}


val empty = Array[Int]()
println(isSorted(empty, (x:Int,y:Int) => x <= y))

val notSorted = Array[Int](1,2,5,8,3,4,5,1)
println(isSorted(notSorted, (x:Int,y:Int) => x <= y))

val sorted = notSorted.sortWith(_ < _)
println(isSorted(sorted, (x:Int,y:Int) => x <= y))

