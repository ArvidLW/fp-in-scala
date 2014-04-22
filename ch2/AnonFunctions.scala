object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n else n

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc else go(n-1, n*acc)

    go(n, 1)
  }

  private def formatResult(name: String, x: Int, f: Int => Int) = {
    val msg = "The %s value of %d is %d"
    msg.format(name, x, f(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 10, factorial))
    println(formatResult("incrementA", 1, _ + 1))
    println(formatResult("incrementB", 2, (x: Int) => x + 1))
    println(formatResult("incrementC", 3, x => x + 1))
    println(formatResult("incrementD", 4, (x) => x + 1))
    println(formatResult("incrementE", 5, x => { val r = x + 1; r}))
    println(formatResult("incrementF", 6, (x) => { val r = x + 1; r}))
    println(formatResult("incrementD", 7, (x: Int) => { val r = x + 1; r}))    
  }
}



