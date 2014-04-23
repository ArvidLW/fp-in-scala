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

  // def tail(myList: List[Int]): List[Int] = myList match {
  //   case Nil => Nil
  //   case Cons(_, Nil) => Nil
  //   case Cons(_, xs)  => xs
  // }
  def tail(myList: List[Int]): List[Int] = myList match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def drop(n: Int, myList: List[Int]): List[Int] = (n, myList) match {
    case (_, Nil) => Nil
    case (0, Cons(_, xs))  => xs
    case (n, Cons(_, xs)) if n >= 0 => drop(n-1, xs)
    case (n, _) => throw new IllegalArgumentException("N must be non-negative integer.")
  }

  // def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = {
  //   l match {
  //     case Nil => Nil
  //     case Cons(x, xs) if f(x) == false => dropWhile(xs)(f)
  //     case _ => l
  //     // case Cons(x, xs) if f(x) == true  => dropWhile(xs)(f)
  //   }
  // }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h,t) if f(h) => dropWhile(t, f) 
    case _ => l
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

// val y = List(0,2,0,4,5)
// // println(List.dropWhile(y, x => x % 2) == 0 ))
// // val d = (a: Int) => a > 0
// // println(List.dropWhile(y, (a: Int) => (a % 2) == 0))
// println(List.dropWhile(y, (a: Int) => a==0))


// val x = List(1,2,3,4,5)
// println(List.drop(1, x))

// val y = List(1,2,3,4,5)
// println(List.drop(2, y))

// val z = List(1,2,3,4,5)
// println(List.drop(10, x))

// try { 
//   val a = List(1,2,3,4,5)
//   println(List.drop(-1, a))
// } catch {
//  case iae: IllegalArgumentException => println("success")
// }



val x = List(1,2,3,4,5)
println(List.tail(x))

val y = List()
println(List.tail(y))

val z = List(1)
println(List.tail(z))

println(List.tail(Nil))