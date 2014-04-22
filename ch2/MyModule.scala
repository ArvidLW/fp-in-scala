object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n else n
  
  private def formatAbs(x: Int) = {
    // msg cannot be re-assigned a value. 
    val msg = "The absolute value of %d is %d"
    // format, does not throw error for having more arguments then needed
    msg.format(x, abs(x))
    // This works too, though not without the 's'
    // s"The absolute value of $x is ${abs(x)}"
  }
  
  def main(args: Array[String]): Unit =
    println(formatAbs(-42))
}

