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
  def tail(myList: List[Int]): List[Int] = myList match {
    case Nil => Nil
    case Cons(x, Nil) => Nil
    case Cons(x, xs)  => xs
  }
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

val x = List(1,2,3,4,5)
println(List.tail(x))

val y = List()
println(List.tail(y))

val z = List(1)
println(List.tail(z))

println(List.tail(Nil))