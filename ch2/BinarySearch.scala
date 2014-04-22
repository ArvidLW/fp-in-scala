def binarySearch(ds: Array[Double], key: Double): Int = {

  @annotation.tailrec
  def go(low: Int, mid: Int, high: Int): Int = {
    if (low > high) -1
    else {
      val tempMid = (low + high) / 2
      val itemVal = ds(tempMid)
      
      if( itemVal == key) tempMid
      else if (itemVal < key) 
        go(tempMid+1, tempMid, high)
      else 
        go(low, tempMid, tempMid-1)
    }

  }

  go(0, 0, ds.length-1)
}

println(binarySearch(Array(1,2,3,4,5.0,6.0), 5.5))
println(binarySearch(Array(1,2,3,4,5.0,6.0), 5.0))