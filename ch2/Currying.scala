def curryA[A,B,C](f: (A, B) => C): A => (B => C) = (a: A) => ((b: B) => f(a,b))

def curryB[A,B,C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a,b)