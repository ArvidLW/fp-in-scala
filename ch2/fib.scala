def fib(n: Int): Int = {

  def go(n: Int, curr: Int, next: Int): Int = 
    if(n <= 0) next else go(n-1, next, curr+next)

  go(n, 0, 1)
}

println(fib(5))