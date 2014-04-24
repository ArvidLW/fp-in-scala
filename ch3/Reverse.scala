def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = {
  println(s"l:$l, z:$z, f:${f.getClass.getSimpleName}")
  l match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  } 
}

// foldRight(Cons(1, Cons(2, Cons(3, Nil))), 0)(_ + _)
// 1 + foldRight(Cons(2, Cons(3, Nil)), 0)(_ + _)
// 1 + (2 + foldRight(Cons(3, Nil), 0)(_ + _))
// 1 + (2 + (3 + (foldRight(Nil, 0)(_ + _))))
// 1 + (2 + (3 + (0)))
// 6

// def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = l match {
//   case Nil => z
//   case Cons(h, t) => f(foldLeft(t, z)(f), h)
// }

@annotation.tailrec
def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = {
  println(s"l:$l, z:$z, f:${f.getClass.getSimpleName}")
  l match {
    case Nil => z
    case Cons(h,t) => foldLeft(t, f(z,h))(f)
  }
}
// l:Cons(1,Cons(2,Cons(3,Cons(4,Nil)))), z:Nil, f:anonfun$reverse$1
// l:Cons(2,Cons(3,Cons(4,Nil))), z:Cons(1,Nil), f:anonfun$reverse$1
// l:Cons(3,Cons(4,Nil)), z:Cons(2,Cons(1,Nil)), f:anonfun$reverse$1
// l:Cons(4,Nil), z:Cons(3,Cons(2,Cons(1,Nil))), f:anonfun$reverse$1
// l:Nil, z:Cons(4,Cons(3,Cons(2,Cons(1,Nil)))), f:anonfun$reverse$1
// Cons(4,Cons(3,Cons(2,Cons(1,Nil))))



sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
object List {
  def sum(ints: List[Int]): Int = foldLeft(ints, 0)(_ + _)
  def product(ds: List[Double]): Double = foldLeft(ds, 1.0)(_ * _)
  def length[A](l: List[A]): Int = foldLeft(l, 0)((x: Int, _) => x + 1)

  def tail[A](myList: List[A]): List[A] = myList match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  // def reverse[A](l: List[A]): List[A] = foldRight(l, Nil:List[A])(Cons(_,_))
  // def reverse[A](l: List[A]): List[A] = 
  //   foldRight(l, Nil: List[A])((x: A, y: List[A]) => Cons(x, reverse(y)))


  def reverse[A](l: List[A]): List[A] = 
    foldLeft(l, List[A]())((x, y) => Cons(y, x))


  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

val x = List(1,2,3,4)
println(List.reverse(x))
val y = List(1.0,2.0,3.0,4.0)

val z = List(1,2,3,4,5,6,7,8,9)
println(foldRight(z, 0)(_ + _))
