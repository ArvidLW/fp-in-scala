sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}


// foldRight(Cons(1, Cons(2, Cons(3, Nil))), 0)(_ + _)
// 1 + foldRight(Cons(2, Cons(3, Nil)), 0)(_ + _)
// 1 + (2 + foldRight(Cons(3, Nil), 0)(_ + _))
// 1 + (2 + (3 + (foldRight(Nil, 0)(_ + _))))
// 1 + (2 + (3 + (0)))
// 6
def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = l match {
  case Nil => z
  case Cons(x, xs) => f(x, foldRight(xs, z)(f))
} 

def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = l match {
  case Nil => z
  case Cons(h, t) => f(foldLeft(t, z)(f), h)
}

println(foldLeft(List(1,2,3), 0)(_ + _))







