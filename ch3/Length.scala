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
  def length[A](l: List[A]): Int = {
    foldRight(l, 0)( ( _ , x: Int) => x + 1 )
  }
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = l match {
  case Nil => z
  case Cons(x, xs) => f(x, foldRight(xs, z)(f))
}


val x = List()
println(List.length(x))

val y = List(0,2,0,4,5)
println(List.length(y))

val z = List(1)
println(List.length(x))

val a = List(1,2,3,4,5,6,7,8,9)
println(List.length(a))





