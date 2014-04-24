
def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = l match {
  case Nil => z
  case Cons(x, xs) => f(x, foldRight(xs, z)(f))
} 

def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = l match {
  case Nil => z
  case Cons(h, t) => f(foldLeft(t, z)(f), h)
}

// foldRight(Cons(1, Cons(2, Cons(3, Nil))), 0)(_ + _)
// 1 + foldRight(Cons(2, Cons(3, Nil)), 0)(_ + _)
// 1 + (2 + foldRight(Cons(3, Nil), 0)(_ + _))
// 1 + (2 + (3 + (foldRight(Nil, 0)(_ + _))))
// 1 + (2 + (3 + (0)))
// 6

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
object List {
  def sum(ints: List[Int]): Int = foldLeft(ints, 0)(_ + _)
  def product(ds: List[Double]): Double = foldLeft(ds, 1.0)(_ * _)
  def length[A](l: List[A]): Int = foldLeft(l, 0)((x: Int, _) => x + 1)

  def tail(myList: List[Int]): List[Int] = myList match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def reverse[A](l: List[A]): List[A] = foldRight(l, Nil:List[A])(Cons(_,_))

  // def reverse[A](l: List[A]): List[A] = l match {

  // }


  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

val x = List(1,2,3,4)
println(List.reverse(x))
val y = List(1.0,2.0,3.0,4.0)