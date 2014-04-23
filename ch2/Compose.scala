def compose[A,B,C](f: B => C, g: A => B): A => C = (a : A) => f(g(a))



val f = (x: Double) => math.Pi * x
val g = (x: Double) => x + 1

println((f compose g)(2))
println((g andThen f)(2))
println((g andThen g)(2))

println((g compose f)(2))
println((f andThen g)(2))
println((f andThen f)(2))